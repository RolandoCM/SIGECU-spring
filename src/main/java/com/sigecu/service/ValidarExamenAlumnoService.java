/**
 * 
 */
package com.sigecu.service;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.AsignaExamenModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 13/01/2018
 *
 */
public interface ValidarExamenAlumnoService {
	public boolean validaRealizarExamen(int idEvaluacion, int idAlumno, int idEvento) throws BusinessException;
	public boolean validaSegundaOportunidadExamen(int idEvaluacion, int idAlumno, int idEvento) throws BusinessException;
	public boolean validaMostrarRetroalimentarcion(int idEvaluacion, int idAlumno, int idEvento) throws BusinessException;
	public AsignaExamenModel asignarExamen(int idAlumno, int idEvento) throws BusinessException;
}
