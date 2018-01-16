package com.sigecu.service;

import java.util.List;
import java.util.Map;

import com.sigecu.entity.Alumno_Has_Eventos;

public interface AlumnoHasEventoService {

	public abstract Alumno_Has_Eventos findAlumnoHasEventoById(int idAHE);
	
	public abstract void findAlumnoHasEventoByIdAlumnoAndIdEvento(int id_alumno, int id_evento);

	List<Map<String, Object>> report(int id_alumno, int id_evento);
	
}
