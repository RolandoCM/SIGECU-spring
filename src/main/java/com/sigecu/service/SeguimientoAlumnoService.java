package com.sigecu.service;

import java.util.List;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;

public interface SeguimientoAlumnoService {
	public abstract AlumnoModel findAlumno(int idAlumno) throws BusinessException;
	public abstract List<Object> datosAlumno(AlumnoModel alumnoModel, int idEvento) throws BusinessException;
	public abstract boolean activarExamenAlumno(int idAsignaExamen, AsignaExamenModel asignaExamen) throws BusinessException;
}
