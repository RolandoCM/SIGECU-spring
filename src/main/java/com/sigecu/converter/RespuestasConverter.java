/**
 * 
 */
package com.sigecu.converter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Preguntas;
import com.sigecu.entity.RespuestaALMEntity;
import com.sigecu.entity.Respuestas;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.RespuestaALMModel;
import com.sigecu.model.RespuestasModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 17/12/2017
 *
 */
@Component("respuestasConverter")
public class RespuestasConverter {
	@Autowired
	@Qualifier("RespuestasALMConverter")
	private RespuestasALMConverter respuestasAMLConverter;
	
	private static final Log LOG = LogFactory.getLog(RespuestasConverter.class);

	// entity -- to -- model
	public RespuestasModel converterRespuestasToRespuestasModel(Respuestas respuestas) throws BusinessException {
		
		RespuestasModel respModel = new RespuestasModel();
		try {
		respModel.setIdRespuesta(respuestas.getIdRespuesta());
		respModel.setrSolucion(respuestas.getrSolucion());
		respModel.setPregunta(respuestas.getPreguntas());
		respModel.setrRespuesta(respuestas.getrRespuesta());
		LOG.info("Conversion correcta: RESPUESTA A RESPUESTA MODEL");
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir respuesta a respuestaModel");
			throw be;
		}

		return respModel;

	}
	// entity -- to -- model
		public RespuestasModel converterRespuestasToRespuestasModelAndAML(Respuestas respuestas) throws BusinessException{
			
			
			RespuestasModel respModel = new RespuestasModel();
			
			//List<RespuestaALMModel> respuestasALMModel = new ArrayList<>();
			//Iterator<RespuestaALMEntity> iterALM =  respuestas.getRespuestasAML().iterator();
//			while(iterALM.hasNext()) {
//				RespuestaALMModel respALM = 
//						respuestasAMLConverter.converterRespuestaALMToRespuestasModel(iterALM.next());
//				respuestasALMModel.add(respALM);
//			}
			try {
			respModel.setIdRespuesta(respuestas.getIdRespuesta());
			respModel.setrSolucion(respuestas.getrSolucion());
			respModel.setPregunta(respuestas.getPreguntas());
			respModel.setrRespuesta(respuestas.getrRespuesta());
			//respModel.setRespuestaALMModel(respuestasALMModel);
			LOG.info("Conversion correcta: RESPUESTA A RESPUESTA MODEL");
			}
			catch(Exception e) {
				LOG.error("METODO NO EJECUTADO");
				BusinessException be = new BusinessException();
				be.printStackTrace();
				be.setIdException(001);
				be.setMsj("ERROR EN SERVICE: Convertir respuesta a respuestaModel");
				throw be;
			}

			return respModel;

		}

	// model -- to -- entity
	public Respuestas converterRespuestasModelToRespuestas(RespuestasModel respuestasModel, Preguntas preguntas) throws BusinessException {
		Respuestas resp = new Respuestas();
		try {
		resp.setPreguntas(preguntas);
		resp.setrRespuesta(respuestasModel.getrRespuesta());
		resp.setrSolucion(respuestasModel.getrSolucion());
		LOG.info("Conversion correcta: RESPUESTA MODEL A RESPUESTA");
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be=new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir respuestaModel a respuesta");
			throw be;
		}

		return resp;
	}
}
