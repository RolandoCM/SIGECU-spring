package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sigecu.model.CursoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.model.InstructorModel;
import com.sigecu.entity.Eventos;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Instructor;

@Component("eventosConverter")
public class EventosConverter {
	private static final Log LOG = LogFactory.getLog(EventosConverter.class);

	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter cursosConverter;
	
	@Autowired
	@Qualifier("instructorConverter")
	private InstructorConverter instructorConverter;
	
	//Entidad a Modelo
	
	public EventosModel convertEventoToEentoModel(Eventos evento) {
		 EventosModel eventoModel=new EventosModel();
		 CursoModel curso = cursosConverter.convertCursoToCursoModel(evento.getCursosEvento());
		 InstructorModel instructor= instructorConverter.converterEntityToModel(evento.getInstructor());
		 eventoModel.setIdevento(evento.getIdEvento());
		 eventoModel.seteDescripcion(evento.geteDescripcion());
		 eventoModel.seteFechaInicio(evento.geteFechaInicio());
		 eventoModel.seteFechaTermino(evento.geteFechaTermino());
		 eventoModel.setePrograma(evento.getePrograma());
		 eventoModel.seteHorario(evento.geteHorario());
		 eventoModel.seteCapacidad(evento.geteCapacidad());
		 eventoModel.seteTipo(evento.geteTipo());
		 eventoModel.seteEstatus(evento.geteStatus());
		 
		 return eventoModel;
	}
	
	
	//Modelo a Entidad
	
	public Eventos convertEventoModelToEvento (EventosModel evento, Cursos curso, Instructor instructor) {
		Eventos even=new Eventos() ;
		even.setIdEvento(evento.getIdevento());
		even.seteDescripcion(evento.geteDescripcion());
		even.seteFechaInicio(evento.geteFechaInicio());
		even.seteFechaTermino(evento.geteFechaTermino());
		even.setePrograma(evento.getePrograma());
		even.seteHorario(evento.geteHorario());
		even.seteCapacidad(evento.geteCapacidad());
		even.seteTipo(evento.geteTipo());
		even.seteStatus(evento.geteEstatus());
		return even;
		
	}
}
