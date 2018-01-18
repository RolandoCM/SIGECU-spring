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
import com.sigecu.exception.BusinessException;
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
	public List<EvaluacionesModel> listarEvaluaciones(int idCurso) throws BusinessException {
		List<Evaluaciones> evaluaciones = queryEvaluacion.findAllExamenesById(idCurso);
		List<EvaluacionesModel> evaluacionModel = new ArrayList<EvaluacionesModel>();
		
		try {
			
		for (Evaluaciones evaluacion : evaluaciones) {
			evaluacionModel.add(evaluacionConverter.convertEvaluacion2EvaluacionModel(evaluacion));
		}
		LOG.info("BUSCAR examen de CURSO " + idCurso);
		
		return evaluacionModel;
	
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Error en busqueda de curso");
			throw be;
		}
		
	}

	
	//listar CUrsos
	public List<CursoModel> listaCursos() throws BusinessException{
		List<Cursos> cursos = cursoRepository.findAll();
		List<CursoModel> cursoModel = new ArrayList<CursoModel>();
		
		try {
		
		for (Cursos curso : cursos) {
			cursoModel.add(cursosConverter.convertCursoToCursoModel(curso));
		}
		
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir curso a CursoModel");
			throw be;
		}
		return cursoModel;
	
	}


	@Override
	public List<PreguntasRetroModel> listarPregunrasByExam(int idEvaluacion, int idAsignaExamen) throws BusinessException {
		List<Preguntas> listPreguntas = queryEvaluacion.findAllPreguntasById(idEvaluacion);
		List<Preguntas> listPreguntasErr = queryEvaluacion.findPreguntasErradasRetro(idEvaluacion, idAsignaExamen);
		List<PreguntasRetroModel> preguntasRetroModel = new ArrayList<PreguntasRetroModel>();
		
		try {

		for (Preguntas pregunta : listPreguntas) {
			if(listPreguntasErr.contains(pregunta)) {
				preguntasRetroModel.add(preguntasConverter.converterPreguntasToPreguntasModelAndRespuestasRetro(pregunta, 0));
				LOG.info("ES INCORRECTA : "+pregunta.getIdPregunta()+"...............");
			}
			else {
				preguntasRetroModel.add(preguntasConverter.converterPreguntasToPreguntasModelAndRespuestasRetro(pregunta, 1));
				LOG.info("ES CORRECTA : "+pregunta.getIdPregunta()+"...............");
			}
		}
		LOG.info("TOTAL: PREGUNTAS : "+ listPreguntas.size());
		//LOG.info(preguntasModel.iterator().next().getRespuestasModel().iterator().next().getPregunta());
		return preguntasRetroModel;
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: PREGUNTAS FUERA DE INDICE / PREGUNTAS NO ENCONTRADAS ");
			throw be;
			
		}
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
