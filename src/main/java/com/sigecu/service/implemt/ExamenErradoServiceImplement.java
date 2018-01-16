/**
 * 
 */
package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.PreguntasConverter;
import com.sigecu.converter.RespuestasConverter;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.RespuestaALMEntity;
import com.sigecu.model.PreguntasModel;
import com.sigecu.repository.AsignaExamenRepository;
import com.sigecu.repository.EvaluacionRepository;
import com.sigecu.repository.PreguntasRepository;
import com.sigecu.repository.QueryEvaluacion;
import com.sigecu.repository.QueryPreguntasErradasCon;
import com.sigecu.repository.RespuestasRepository;
import com.sigecu.repository.respuestaALMRepository;
import com.sigecu.service.ExamenErradoService;

/**
 * @author Anel
 *
 */
@Service ("ExamenErradoServiceImplement")
public class ExamenErradoServiceImplement implements ExamenErradoService {
	
	private static final Log LOG = LogFactory.getLog(ExamenErradoServiceImplement.class);


	@Autowired
	@Qualifier("preguntasConverter")
	private PreguntasConverter preguntasConverter;
	
	@Autowired
	@Qualifier("preguntasRepository")
	private PreguntasRepository preguntasRepository;

	@Autowired
	@Qualifier("queryEvaluacion")
	private QueryEvaluacion queryEvaluacion;
	
	@Autowired
	@Qualifier("respuestasRepository")
	private RespuestasRepository respuestasRepository;

	@Autowired
	@Qualifier("respuestasConverter")
	private RespuestasConverter respuestasConverter;
	@Autowired
	@Qualifier("evaluacionesRepository")
	private EvaluacionRepository evaluacionesRepository;
	@Autowired
	@Qualifier("asignaExamenRepository")
	private AsignaExamenRepository asignaExamenRepository;
	
	@Autowired
	@Qualifier("queryPreguntaErradaRepository")
	private QueryPreguntasErradasCon queryPreguntasErradasRepository;
	@Autowired
	@Qualifier("respuestasALMRepository")
	private respuestaALMRepository respuestaALMRepository;
	
	@Override
	public List<PreguntasModel> listarPreguntasByExamErrado(int idEvaluacion, int idAsignaExamen){
		List<Preguntas> preguntas = queryPreguntasErradasRepository.findPreguntasErradas(idEvaluacion, idAsignaExamen);
		List<PreguntasModel> preguntasModel = new ArrayList<>();
		for(Preguntas pregunta : preguntas ) {
			preguntasModel.add(preguntasConverter.converterPreguntasToPreguntasModelAndRespuestas(pregunta));
		}
		LOG.info("LAS PREGUNTAS HERRADAS: "+ preguntasModel.size());
		
		return preguntasModel;
	}


	/* (non-Javadoc)
	 * @see com.sigecu.service.ExamenErradoService#guardarRespuestas(int, int, int)
	 */
	@Override
	public void guardarRespuestas(int idRespuesta, int idAsignaExamen, int idPregunta) {
		RespuestaALMEntity respuestaALMEntity = respuestaALMRepository.findByIdPregunta(idPregunta);
		
		AsignaExamenEntity asignaExamen = asignaExamenRepository.findByIdasignaExamen(idAsignaExamen);
		respuestaALMEntity.setSeleccionada("2");
		respuestaALMEntity.setIdRespuesta(idRespuesta);
		respuestaALMEntity.setIdPregunta(idPregunta);
		respuestaALMEntity.setAsignaExamen(asignaExamen);
		respuestaALMRepository.save(respuestaALMEntity);
		LOG.info("RESPUESTA REGISTRADA: " + respuestaALMEntity.toString());

	}


	/* (non-Javadoc)
	 * @see com.sigecu.service.ExamenErradoService#marcarExamenRealizado(int)
	 */
	@Override
	public void marcarExamenRealizado(int idAsignaExamen) {
		AsignaExamenEntity asignaExamen = asignaExamenRepository.findByIdasignaExamen(idAsignaExamen);
		asignaExamen.setRealizado("1");
		asignaExamenRepository.save(asignaExamen);
		
	}


}
