package com.sigecu.service;


public interface CalificacionService {
	public abstract double []calificacionFnl(int idEvaluacion, int idAsignaExamen);
	public abstract void validarCalificacion(double [] resumen, int idAsignaExamen, int idEvaluacion);
	
}
