/**
 * 
 */
package com.sigecu.converter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Preguntas;
import com.sigecu.entity.Respuestas;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.PreguntasRetroModel;
import com.sigecu.model.RespuestasModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 17/12/2017
 *
 */
@Component("preguntasConverter")
public class PreguntasConverter {
	@Autowired
	@Qualifier("respuestasConverter")
	private RespuestasConverter respuestasConverter;
	
	private static final Log LOG = LogFactory.getLog(PreguntasConverter.class);

	// entity -- to -- model
	public PreguntasModel converterPreguntasToPreguntasModel(Preguntas preguntas) throws BusinessException{
		PreguntasModel preguntaModel = new PreguntasModel();
		
		try {
			preguntaModel.setIdPregunta(preguntas.getIdPregunta());
			preguntaModel.setpPregunta(preguntas.getpPregunta());
			preguntaModel.setpDescripcion(preguntas.getpDescripcion());
			preguntaModel.setEvaluacion(preguntas.getEvaluaciones());
			preguntaModel.setPuntaje(preguntas.getpPuntaje());
			LOG.info("Conversion correcta: Pregunta a PreguntaModel");
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir pregunta a preguntaModel");
			throw be;
		}
		
		return preguntaModel;
	}
	/*
	 * Convertir preguntas con respuesta tipo model agregado
	 * */
	public PreguntasModel converterPreguntasToPreguntasModelAndRespuestas(Preguntas preguntas) throws BusinessException {
		PreguntasModel preguntaModel = new PreguntasModel();
		
		List<RespuestasModel> respuestasModel = new ArrayList<>();
		Iterator<Respuestas> iter = preguntas.getRespuestas().iterator();
		try {
		while(iter.hasNext()) {
			RespuestasModel respuesta = respuestasConverter.converterRespuestasToRespuestasModelAndAML(iter.next());
			respuestasModel.add(respuesta);
	
			preguntaModel.setIdPregunta(preguntas.getIdPregunta());
			preguntaModel.setpPregunta(preguntas.getpPregunta());
			preguntaModel.setpDescripcion(preguntas.getpDescripcion());
			preguntaModel.setEvaluacion(preguntas.getEvaluaciones());
			preguntaModel.setPuntaje(preguntas.getpPuntaje());
			preguntaModel.setRespuestasModel(respuestasModel);
			LOG.info("Conversion correcta: Pregunta a PreguntaModel");
		}
		
		}
		
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir preguntas con respuestaModel");
			throw be;
		
	}
	
		return preguntaModel;
		
}
	
	
	/*
	 * Convertir preguntas con respuesta tipo model agregado para retroalimentacion
	 * */
	public PreguntasRetroModel converterPreguntasToPreguntasModelAndRespuestasRetro(Preguntas preguntas, int correcto) throws BusinessException {
		PreguntasRetroModel preguntaModel = new PreguntasRetroModel();
		
		List<RespuestasModel> respuestasModel = new ArrayList<>();
		Iterator<Respuestas> iter = preguntas.getRespuestas().iterator();
		
		try {
		while(iter.hasNext()) {
			RespuestasModel respuesta = respuestasConverter.converterRespuestasToRespuestasModelAndAML(iter.next());
			respuestasModel.add(respuesta);
			
			preguntaModel.setIdPregunta(preguntas.getIdPregunta());
			preguntaModel.setPreguntaEnun(preguntas.getpPregunta());
			preguntaModel.setDescripcion(preguntas.getpDescripcion());
			preguntaModel.setRespuestasModel(respuestasModel);
			preguntaModel.setCorrecta(correcto);
		}
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir preguntas con respuestaModel para retroalimentacion");
			throw be;
		}
		
		
		return preguntaModel;
	}

	// model -- to -- entity
	public Preguntas converterPreguntaModelToPreguntas(PreguntasModel preguntaModel, Evaluaciones eval) throws BusinessException {
		Preguntas pregunta = new Preguntas();
		
		try {
			pregunta.setpPregunta(preguntaModel.getpPregunta());
			pregunta.setpPuntaje(preguntaModel.getPuntaje());
			pregunta.setpDescripcion(preguntaModel.getpDescripcion());
			pregunta.setEvaluaciones(eval);
			
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN CONVERTER: Convertir preguntaModel a pregunta");
			throw be;
			
		}
		
		return pregunta;
	}
}
