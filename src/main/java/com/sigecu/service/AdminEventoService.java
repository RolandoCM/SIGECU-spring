package com.sigecu.service;

import java.util.List;

import com.sigecu.model.CursoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.model.InstructorModel;

public interface AdminEventoService {

	public abstract List<CursoModel> listaCursos();
	public abstract List<InstructorModel> listaInstructor();
	public abstract void nuevoEvento(EventosModel eventoModel, int idCurso, int idInstructor);	
	

}
