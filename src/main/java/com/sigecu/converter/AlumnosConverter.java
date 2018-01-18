/**
 * 
 */
package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Alumno;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Component("alumnosConverter")
public class AlumnosConverter {

private static final Log LOG = LogFactory.getLog(CertificadoConverter.class);
	
	//entity -- to -- model
	public AlumnoModel converterAlumnoToAlumnoModel(Alumno alumno) throws BusinessException{
		AlumnoModel alumnoModel = new AlumnoModel();
		
		try {
		alumnoModel.setId_alumno(alumno.getIdAlumno());
		alumnoModel.setA_nombre(alumno.getaNombre());
		alumnoModel.setA_paterno(alumno.getaPaterno());
		alumnoModel.setA_materno(alumno.getaMaterno());
		alumnoModel.setA_carrera(alumno.getaCarrera());
		alumnoModel.setA_email(alumno.getaEmail());
		alumnoModel.setA_telefono(alumno.getaTelefono());
		alumnoModel.setA_notebook(alumno.getaNotebook());
		alumnoModel.setA_status(alumno.getaStatus());
		LOG.info("ALUMNO se convierte a MODEL");
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convierte alumno a alumnoModel");
			throw be;
			
		}
		return alumnoModel;
	}
	
	//model -- to -- entity
	

}
