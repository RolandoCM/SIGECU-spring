package com.sigecu.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Alumno;
import com.sigecu.entity.AlumnoEventosId;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Eventos;
import com.sigecu.model.AltaAlumnoModel;
import com.sigecu.repository.AlumnoRepository;
import com.sigecu.repository.EventosRepository;

@Component("altaAlumnosConverter")
public class AltaAlumnosConverter {
	
	@Autowired 
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumnoRepository;
	@Autowired
	@Qualifier("eventosRepository")
	private EventosRepository eventoRepository;
	
	public Alumno_Has_Eventos converterAltaAlumnoToAheEntity(AltaAlumnoModel aam, AsignaExamenEntity asignaExamen) {
		Alumno_Has_Eventos ahe = new Alumno_Has_Eventos();
		int activo = Integer.parseInt(aam.getActivo());
		int idAlumno = Integer.parseInt(aam.getIdAlumno());
		int idEvento = Integer.parseInt(aam.getIdEvento());
		Alumno alumno = alumnoRepository.findByIdAlumno(idAlumno);
		Eventos evento = eventoRepository.findByIdEvento(idEvento);
		
		AlumnoEventosId primaryKey = new AlumnoEventosId();
		primaryKey.setAlumno(alumno);
		primaryKey.setEventos(evento);
		
		ahe.setActivo(activo);
		ahe.setConfirmado(aam.getConfirmado());
		ahe.setAsignaExamen(asignaExamen);
		ahe.setPrimaryKey(primaryKey);
		
		
		return ahe;
	}
}
