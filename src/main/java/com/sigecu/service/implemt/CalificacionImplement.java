package com.sigecu.service.implemt;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.EvaluacionConverter;
import com.sigecu.converter.RespuestasALMConverter;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.RespuestaALMEntity;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.RespuestaALMModel;
import com.sigecu.repository.AsignaExamenRepository;
import com.sigecu.repository.CalificacionRepository;
import com.sigecu.repository.EvaluacionRepository;
import com.sigecu.repository.PreguntasRepository;
import com.sigecu.repository.QueryCalificacion;
import com.sigecu.service.CalificacionService;

@Service("CalificacionImplement")

public class CalificacionImplement implements CalificacionService {
	private static final Log LOG = LogFactory.getLog(CalificacionImplement.class);
	/*
	@Autowired
	@Qualifier("calificacionRepository")
	private CalificacionRepository calificacionRepository;
	
	@Autowired
	@Qualifier("RespuestasALMConverter")
	private RespuestasALMConverter respuestaAlumnConverter;
	
	
	public String aciertosPregunta(int idrespuestaALM) {
		calificacionRepository.findT_Respuestas().
		RespuestaALMEntity resp= calificacionRepository.findByidrespuestaALM(idrespuestaALM);
	    RespuestaALMModel respmodel = respuestaAlumnConverter.converterRespuestaALMToRespuestasModel(resp);
		LOG.error(respmodel.getSeleccionada());
	    return respmodel.toString();
	}
	*/
	
	
	@Autowired
	@Qualifier("calificacionRepository")
	private CalificacionRepository calificacionRepository;
	@Autowired
	@Qualifier("queryCalificacion")
	private QueryCalificacion queryCalificacion;
	@Autowired
	@Qualifier("preguntasRepository")
	private PreguntasRepository preguntasRepository;
	@Autowired 
	@Qualifier("evaluacionesRepository")
	private EvaluacionRepository evaluacionRepository;
	@Autowired
	@Qualifier("asignaExamenRepository")
	private AsignaExamenRepository asignaExamenRepository;


	@Override
	public double [] calificacionFnl(int idEvaluacion, int idAsignaExamen) {
		List<Preguntas> preguntasAcertadas = queryCalificacion.aciertos(idEvaluacion, idAsignaExamen);
		Evaluaciones eval = evaluacionRepository.findByIdEvaluacion(idEvaluacion);
		List<Preguntas> preguntasTotal = preguntasRepository.findByEvaluaciones(eval);
		double aciertos = preguntasAcertadas.size();
		double total =preguntasTotal.size();
		double erradas = total - aciertos;
		double calificacion =  aciertos / total * 100.0;
		double [] resumen = {calificacion, aciertos, erradas};
		return resumen;
	}


	@Override
	public void validarCalificacion(double[] resumen, int idAsignaExamen, int idEvaluacion) {
		Evaluaciones evaluacion = evaluacionRepository.findByIdEvaluacion(idEvaluacion);
		AsignaExamenEntity asignaExamen = asignaExamenRepository.findByIdasignaExamen(idAsignaExamen);
		double minimo = Double.parseDouble(evaluacion.getePorsentaje());
		if(minimo<=resumen[0]) {
			asignaExamen.setStatus("1");
		}
		else {
			asignaExamen.setStatus("0");
		}
		asignaExamenRepository.save(asignaExamen);
		LOG.info("EL ALUMNO TIENE UN EXAMEN EN: "+asignaExamen.getStatus());
		
	}

}
