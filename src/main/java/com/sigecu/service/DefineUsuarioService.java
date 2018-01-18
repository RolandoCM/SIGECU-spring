/**
 * 
 */
package com.sigecu.service;

import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.InstructorModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
public interface DefineUsuarioService {
	public abstract AlumnoModel buscarUsuarioAlumno(String user) throws BusinessException;
	public abstract InstructorModel buscarUsuarioInstructor(String user) throws BusinessException;
}
