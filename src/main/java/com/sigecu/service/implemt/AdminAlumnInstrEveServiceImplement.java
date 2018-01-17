package com.sigecu.service.implemt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.AlumnosConverter;
import com.sigecu.converter.ConverterAlumnoUserConverter;
import com.sigecu.entity.Alumno;
import com.sigecu.entity.UserRole;
import com.sigecu.entity.Users;
import com.sigecu.model.AlumnoModel;
import com.sigecu.repository.AlumnoRepository;
import com.sigecu.repository.UserRepository;
import com.sigecu.repository.User_Role_Repository;
import com.sigecu.service.AdminAlumnInstrEveService;

@Service("adminAlumnInstrEvServiceImpl")
public class AdminAlumnInstrEveServiceImplement implements AdminAlumnInstrEveService{

	private static final Log LOG = LogFactory.getLog(AdminAlumnInstrEveServiceImplement.class);

	@Autowired
	@Qualifier("alumnosConverter")
	private AlumnosConverter alumnoConverter;
	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumRepo;
	
	@Autowired
	@Qualifier("alumnoConverterUsu")
	private ConverterAlumnoUserConverter alumnoUserConverter;
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepo;
	
	@Autowired
	@Qualifier("userRoleRepository")
	private User_Role_Repository rolerepo;
	
	@Override
	public void nuevoAlumno(AlumnoModel almmod) {
		
		Users usuarios=alumnoUserConverter.converterUserCredencialModelToUsers(almmod);
		userRepo.saveAndFlush(usuarios);
		LOG.info("USUARIO INSERTADO");
		UserRole rolerus =alumnoUserConverter.converterUserModelToUserRole(almmod);
		rolerepo.saveAndFlush(rolerus);		
		LOG.info("ROL USUARIO INSERTADO");
		Alumno Alum = alumnoUserConverter.converterAlumnoModelToAlumno(almmod);
		alumRepo.saveAndFlush(Alum);
		LOG.info("ALUMNO INSERTADO");
		
		
		
	}

}
