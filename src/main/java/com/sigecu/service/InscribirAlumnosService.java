package com.sigecu.service;

import java.util.List;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.AltaAlumnoModel;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.EventosModel;

public interface InscribirAlumnosService {
	public abstract List<AlumnoModel> alumnosAll() throws BusinessException;
	public abstract List<EventosModel> eventosAll() throws BusinessException;
	public abstract void altaAlumnoAEvento( AltaAlumnoModel altaAE) throws BusinessException;
}
