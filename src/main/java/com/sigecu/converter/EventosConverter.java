package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.model.EventosModel;
import com.sigecu.entity.Eventos;
import com.sigecu.exception.BusinessException;

@Component("eventosConverter")
public class EventosConverter {
	private static final Log LOG = LogFactory.getLog(EventosConverter.class);

	//Entidad a Modelo
	
	public EventosModel convertEventoToEentoModel(Eventos evento)  throws BusinessException{
		 EventosModel eventoModel=new EventosModel();
		 
		 try {
		 eventoModel.setIdevento(evento.getIdEvento());
		 eventoModel.seteDescripcion(evento.geteDescripcion());
		 eventoModel.seteFechaInicio(evento.geteFechaInicio());
		 eventoModel.seteFechaTermino(evento.geteFechaTermino());
		 eventoModel.setePrograma(evento.getePrograma());
		 eventoModel.seteHorario(evento.geteHorario());
		 eventoModel.seteCapacidad(evento.geteCapacidad());
		 eventoModel.seteTipo(evento.geteTipo());
		 eventoModel.seteEstatus(evento.geteStatus());
		 eventoModel.setCurso(evento.getCursosEvento());
		 eventoModel.setInstructor(evento.getInstructor());
		 }
		 catch(Exception e) {
			 LOG.error("METODO NO EJECUTADO");
			 BusinessException be = new BusinessException();
			 be.printStackTrace();
			 be.setIdException(001);
			 be.setMsj("ERROR EN SERVICE: Convertir evento a eventoModel");
			 throw be;
		 }
		 return eventoModel;
	}
	
	
	//Modelo a Entidad
	
	public Eventos convertEventoModelToEvento (EventosModel evento) throws BusinessException {
		Eventos even=new Eventos() ;
		
		try {
		even.setIdEvento(evento.getIdevento());
		even.seteDescripcion(evento.geteDescripcion());
		even.seteFechaInicio(evento.geteFechaInicio());
		even.seteFechaTermino(evento.geteFechaTermino());
		even.setePrograma(evento.getePrograma());
		even.seteHorario(evento.geteHorario());
		even.seteCapacidad(evento.geteCapacidad());
		even.seteTipo(evento.geteTipo());
		even.seteStatus(evento.geteEstatus());
		even.setInstructor(evento.getInstructor());
		even.setCursosEvento(evento.getCurso());
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICIO: Convertir eventoModel a evento");
			throw be;
		}
		return even;
		
	}
}
