package com.sigecu.service;

import com.sigecu.exception.BusinessException;

public interface CalificacionService {
	public abstract double []calificacionFnl(int idEvaluacion, int idAsignaExamen) throws BusinessException;
	
}
