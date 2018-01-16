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
import com.sigecu.entity.Respuestas;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.RespuestasModel;
import com.sigecu.repository.CursosRepository;
import com.sigecu.repository.EvaluacionRepository;
import com.sigecu.repository.PreguntasRepository;
import com.sigecu.repository.QueryEvaluacion;
import com.sigecu.repository.RespuestasRepository;
import com.sigecu.service.AdminExamService;

@Service("adminExamServiceImpl")
public class AdminExamServiceImpl implements AdminExamService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#listAllEvaluaciones()
	 */
	private static final Log LOG = LogFactory.getLog(AdminExamServiceImpl.class);
	@Autowired
	@Qualifier("evaluacionesRepository")
	private EvaluacionRepository evaluacionesRepository;

	@Autowired
	@Qualifier("evalaucionesConverter")
	private EvaluacionConverter evaluacionConverter;

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
	@Qualifier("preguntasConverter")
	private PreguntasConverter preguntasConverter;

	@Autowired
	@Qualifier("preguntasRepository")
	private PreguntasRepository preguntasRepository;

	@Autowired
	@Qualifier("respuestasRepository")
	private RespuestasRepository respuestasRepository;

	@Autowired
	@Qualifier("respuestasConverter")
	private RespuestasConverter respuestasConverter;
	


	@Override
	public List<EvaluacionesModel> listAllEvaluaciones(int idCurso) {
		List<Evaluaciones> evaluaciones = queryEvaluacion.findAllExamenesById(idCurso);
		List<EvaluacionesModel> evaluacionModel = new ArrayList<EvaluacionesModel>();

		for (Evaluaciones evaluacion : evaluaciones) {
			evaluacionModel.add(evaluacionConverter.convertEvaluacion2EvaluacionModel(evaluacion));
		}
		LOG.info("BUSCAR examen de CURSO " + idCurso);
		return evaluacionModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#listarPregunrasByExam(int)
	 */
	@Override
	public List<PreguntasModel> listarPregunrasByExam(int idExamen) {
		List<Preguntas> listPreguntas = queryEvaluacion.findAllPreguntasById(idExamen);
		List<PreguntasModel> preguntasModel = new ArrayList<PreguntasModel>();
		
		for (Preguntas preg : listPreguntas) {
			preguntasModel.add(preguntasConverter.converterPreguntasToPreguntasModel(preg));
		}
		return preguntasModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#listaCursos()
	 */
	@Override
	public List<CursoModel> listaCursos() {
		List<Cursos> cursos = cursoRepository.findAll();
		List<CursoModel> cursoModel = new ArrayList<CursoModel>();
		for (Cursos curso : cursos) {
			cursoModel.add(cursosConverter.convertCursoToCursoModel(curso));
		}
		return cursoModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#nuevaEvaluacion()
	 */
	@Override
	public void nuevaEvaluacion(EvaluacionesModel evalModel, int idCurso) {
		LOG.info("NUEVO EXAMEN POR REGISTRAR CON CURSO ID: " + idCurso);
		Cursos curso = cursoRepository.findByIdCurso(idCurso);
//		Iterator<Evaluaciones> evale = curso.getEvaluaciones().iterator();
//		while(evale.hasNext()) {
//			LOG.info("LAS EVALUACIONES SON: "+evale.next().geteNombre());
//		}
		Evaluaciones eval = evaluacionConverter.convertEvaluacionModelToEvaluacion(evalModel, curso);
		evaluacionesRepository.saveAndFlush(eval);
		LOG.info("EXAMEN REGISTRADO");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#nuevaPregunta(com.sigecu.model.
	 * PreguntasModel, int)
	 */
	@Override
	public void nuevaPregunta(PreguntasModel preguntaModel, int idEvaluacion) {
		Evaluaciones eval = evaluacionesRepository.findByIdEvaluacion(idEvaluacion);
		Preguntas preguntas = preguntasConverter.converterPreguntaModelToPreguntas(preguntaModel, eval);
		preguntasRepository.saveAndFlush(preguntas);
		LOG.info("PREGUNTA REGISTRADA");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#nuevaRespuesta(com.sigecu.model.
	 * RespuestasModel, int)
	 */
	@Override
	public void nuevaRespuesta(RespuestasModel respuestasModel, int idPregunta) {
		Preguntas pregunta = preguntasRepository.findByIdPregunta(idPregunta);
		//pregunta.getRespuestas().iterator().next().getRespuestasAML().iterator().next().getSeleccionada();
		Respuestas respuesta = respuestasConverter.converterRespuestasModelToRespuestas(respuestasModel, pregunta);
		respuestasRepository.save(respuesta);
		LOG.info("RESPUESTA AGREGADA");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#listarRespuestas()
	 */
	@Override
	public List<RespuestasModel> listarRespuestas() {
		List<Respuestas> respuestas = respuestasRepository.findAll();
		List<RespuestasModel> respModel = new ArrayList<RespuestasModel>();
		for (Respuestas resp : respuestas) {
			respModel.add(respuestasConverter.converterRespuestasToRespuestasModel(resp));
		}
		return respModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.AdminExamService#eliminaPregunta(int)
	 */
	@Override
	public void eliminaPregunta(int idPregunta) {
		Preguntas pregunta =preguntasRepository.findByIdPregunta(idPregunta);
		List<Respuestas> respuestas = queryEvaluacion.findAllRespuestasByIdPregunta(idPregunta);
		respuestasRepository.delete(respuestas);
		preguntasRepository.delete(pregunta);

	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.AdminExamService#eliminarRespuesta(int)
	 */
	@Override
	public void eliminarRespuesta(int idRespuesta) {
		Respuestas respuesta = respuestasRepository.findByIdRespuesta(idRespuesta);
		respuestasRepository.delete(respuesta);
		
	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.AdminExamService#eliminarExamen(int)
	 */
	@Override
	public void eliminarExamen(int idEvaluacion) {
		List<Preguntas> preguntas = queryEvaluacion.findAllPreguntasById(idEvaluacion);
		for(Preguntas pregunta : preguntas) {
			List<Respuestas>  respuestas = queryEvaluacion.findAllRespuestasByIdPregunta(pregunta.getIdPregunta());
			respuestasRepository.delete(respuestas);
		}
		preguntasRepository.delete(preguntas);
		Evaluaciones evaluacion = evaluacionesRepository.findByIdEvaluacion(idEvaluacion);
		evaluacionesRepository.delete(evaluacion);
		
		
	}

}
