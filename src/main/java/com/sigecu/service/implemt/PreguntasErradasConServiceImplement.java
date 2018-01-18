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

import com.sigecu.converter.CursosConverter;
import com.sigecu.converter.EvaluacionConverter;
import com.sigecu.converter.PreguntasConverter;
import com.sigecu.converter.RespuestasConverter;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.RespuestaALMEntity;
import com.sigecu.entity.Respuestas;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.PreguntasRetroModel;
import com.sigecu.model.RespuestaALMModel;
import com.sigecu.model.RespuestasModel;
import com.sigecu.repository.CursosRepository;
import com.sigecu.repository.QueryEvaluacion;
import com.sigecu.repository.RespuestasRepository;
import com.sigecu.repository.respuestaALMRepository;
import com.sigecu.service.PreguntasErradasConService;

/**
 * @author Dell
 *
 */

@Service("preErradasServiceImpl")
public class PreguntasErradasConServiceImplement implements PreguntasErradasConService{

	private static final Log LOG = LogFactory.getLog(PreguntasErradasConServiceImplement.class);
	@Autowired
	@Qualifier("cursoRepository")
	private CursosRepository cursoRepository;
	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter cursosConverter;

	@Autowired
	@Qualifier("queryEvaluacion")
	private QueryEvaluacion queryEvaluacion;

	@Autowired
	@Qualifier("evalaucionesConverter")
	private EvaluacionConverter evaluacionConverter;

	@Autowired
	@Qualifier("preguntasConverter")
	private PreguntasConverter preguntasConverter;

	@Autowired
	@Qualifier("respuestasRepository")
	private RespuestasRepository respuestasRepository;

	@Autowired
	@Qualifier("respuestasConverter")
	private RespuestasConverter respuestasConverter;
	
	@Autowired
	@Qualifier("respuestasALMRepository")
	private respuestaALMRepository respuestaALMRepository;
	
	@Override
	public List<Respuestas> listarPreguntasHerradas() {
		// TODO Auto-generated method stub
		return null;
	}
 //listar Evaluaiones
	@Override
	public List<EvaluacionesModel> listarEvaluaciones(int idCurso) {
		List<Evaluaciones> evaluaciones = queryEvaluacion.findAllExamenesById(idCurso);
		List<EvaluacionesModel> evaluacionModel = new ArrayList<EvaluacionesModel>();

		for (Evaluaciones evaluacion : evaluaciones) {
			evaluacionModel.add(evaluacionConverter.convertEvaluacion2EvaluacionModel(evaluacion));
		}
		LOG.info("BUSCAR examen de CURSO " + idCurso);
		return evaluacionModel;
	}
	
	//listar CUrsos
	public List<CursoModel> listaCursos() {
		List<Cursos> cursos = cursoRepository.findAll();
		List<CursoModel> cursoModel = new ArrayList<CursoModel>();
		for (Cursos curso : cursos) {
			cursoModel.add(cursosConverter.convertCursoToCursoModel(curso));
		}
		return cursoModel;
	}
	@Override
	public List<PreguntasRetroModel> listarPregunrasByExam(int idEvaluacion, int idAsignaExamen) {
		List<Preguntas> listPreguntas = queryEvaluacion.findAllPreguntasById(idEvaluacion);
		List<Preguntas> listPreguntasErr = queryEvaluacion.findPreguntasCorrectaRetro(idEvaluacion, idAsignaExamen);
		List<PreguntasRetroModel> preguntasRetroModel = new ArrayList<PreguntasRetroModel>();
		PreguntasRetroModel preguntaRetro = new PreguntasRetroModel();

		for (Preguntas pregunta : listPreguntas) {
			if(!listPreguntasErr.contains(pregunta)) {
				preguntaRetro = preguntasConverter.converterPreguntasToPreguntasModelAndRespuestasRetro(pregunta, 0);
				
				RespuestaALMEntity rHA =respuestaALMRepository.findByIdPregunta(pregunta.getIdPregunta());
				preguntaRetro.setSeleccionada(rHA.getIdRespuesta());
				preguntasRetroModel.add( preguntaRetro);
				LOG.info("ES INCORRECTA : "+pregunta.getIdPregunta()+"...............");
			}
			else {
				preguntaRetro = preguntasConverter.converterPreguntasToPreguntasModelAndRespuestasRetro(pregunta, 1);
				
				RespuestaALMEntity rHA =respuestaALMRepository.findByIdPregunta(pregunta.getIdPregunta());
				preguntaRetro.setSeleccionada(rHA.getIdRespuesta());
				preguntasRetroModel.add( preguntaRetro);
				LOG.info("ES CORRECTA : "+pregunta.getIdPregunta()+"...............");
			}
		}
		LOG.info("TOTAL: PREGUNTAS : "+ listPreguntas.size());
		//LOG.info(preguntasModel.iterator().next().getRespuestasModel().iterator().next().getPregunta());
		return preguntasRetroModel;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.sigecu.service.PreguntasErradasConService#listarRespuestas()
	 */
	@Override
	public List<RespuestasModel> listarRespuestas() {
		// TODO Auto-generated method stub
		return null;
	}
	/* (non-Javadoc)
	 * @see com.sigecu.service.PreguntasErradasConService#listarRespuestasAlumno()
	 */
	@Override
	public List<RespuestaALMModel> listarRespuestasAlumno() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
