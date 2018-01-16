package com.sigecu.service;

import com.sigecu.model.AlumnoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.EventosModel;

import java.util.List;

public interface eventoAlumnoService {
	public abstract List<EventosModel> listAllEventosAl (int idAlumno);
	public abstract List<AlumnoModel> listaAlumnos();
	public abstract List<EvaluacionesModel> listAllExamen(int idAlumno, int idEvento);
	public abstract String validarcertificado(int idAlumno, int idEvento);

}
