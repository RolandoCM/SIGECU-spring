package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Alumno;
import com.sigecu.entity.UserRole;
import com.sigecu.entity.Users;
import com.sigecu.model.AlumnoModel;
@Component("alumnoConverterUsu")
public class ConverterAlumnoUserConverter {

	private static final Log LOG = LogFactory.getLog(ConverterAlumnoUserConverter.class);
	
		
		//Model to entity
		public Users converterUserCredencialModelToUsers(AlumnoModel userModel) {
			Users usuario = new Users();
			usuario.setUsername(userModel.getA_nombre());
			usuario.setEnabled(true);
			usuario.setImagen("");
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			usuario.setPassword(pe.encode(userModel.getA_nombre()));
			LOG.info("Usuario Convertido");
			return usuario;
		}

		public UserRole converterUserModelToUserRole(AlumnoModel almo) {
			UserRole roleuser=new UserRole();
			roleuser.setDescripcion("Usuario de"+almo.getA_nombre());
			roleuser.setRole("ROLE_ALUMNO");
			Users usuario = new Users();
			usuario.setUsername(almo.getA_nombre());
			usuario.setEnabled(true);
			usuario.setImagen("");
			BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
			usuario.setPassword(pe.encode(almo.getA_nombre()));
			roleuser.setUser(usuario);
			LOG.info("Role Convertido");
			return roleuser;
		}
		//model -- to -- entity
				public Alumno converterAlumnoModelToAlumno(AlumnoModel alm) {
					Alumno almo = new Alumno();
					
					almo.setUser(converterUserCredencialModelToUsers(alm));
					almo.setaNombre(alm.getA_nombre());
					almo.setaPaterno(alm.getA_paterno());
					almo.setaMaterno(alm.getA_materno());
					almo.setaCarrera(alm.getA_carrera());
					almo.setaEmail(alm.getA_email());
					almo.setaTelefono(alm.getA_telefono());
					almo.setaStatus(alm.getA_status());
					almo.setaNotebook(alm.getA_notebook());
					
					LOG.info("AlumnoModel Convertido");
					return almo;
					
					
				}
}
