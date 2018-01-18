package com.sigecu.service;

import java.util.List;

import com.sigecu.entity.Cursos;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.model.InstructorModel;

public interface AdminAlumnInstrEveService {

	
	public abstract void nuevoAlumno(AlumnoModel almmod);
	public abstract void nuevoInstructor(InstructorModel instrucMod);
	public abstract List<CursoModel> listaCursos();
	public abstract List<InstructorModel> listaIntructores();
	public abstract void nuevoEvento(EventosModel evemod);
	
}
