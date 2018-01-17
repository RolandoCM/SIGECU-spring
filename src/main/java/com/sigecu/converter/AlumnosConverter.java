/**
 * 
 */
package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Alumno;
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
	public AlumnoModel converterAlumnoToAlumnoModel(Alumno alumno) {
		AlumnoModel alumnoModel = new AlumnoModel();
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
		return alumnoModel;
	}
	
	//model -- to -- entity
	public Alumno converterAlumnoModelToAlumno(AlumnoModel alm) {
		Alumno almo = new Alumno();
		almo.setaNombre(alm.getA_nombre());
		almo.setaPaterno(alm.getA_paterno());
		almo.setaMaterno(alm.getA_materno());
		almo.setaCarrera(alm.getA_carrera());
		almo.setaEmail(alm.getA_email());
		almo.setaTelefono(alm.getA_telefono());
		almo.setaStatus(alm.getA_status());
		almo.setaNotebook(alm.getA_notebook());
		LOG.info("AlumnoModel se convierte a Alumno");
		return almo;
	}

	}
