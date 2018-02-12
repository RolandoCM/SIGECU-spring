package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.AlumnosConverter;
import com.sigecu.converter.ConverterAlumnoUserConverter;
import com.sigecu.converter.CursosConverter;
import com.sigecu.converter.EventosConverter;
import com.sigecu.converter.InstructorConverter;
import com.sigecu.entity.Alumno;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Eventos;
import com.sigecu.entity.Instructor;
import com.sigecu.entity.UserRole;
import com.sigecu.entity.Users;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.model.InstructorModel;
import com.sigecu.repository.AlumnoRepository;
import com.sigecu.repository.CursosRepository;
import com.sigecu.repository.EventosRepository;
import com.sigecu.repository.InstructorRepository;
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
	
	@Autowired
	@Qualifier("instructorRepository")
	private InstructorRepository instrurepo;
	
	@Autowired
	@Qualifier("cursoRepository")
	private CursosRepository cursorepo;
	
	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter curconver;
	
	@Autowired
	@Qualifier("instructorConverter")
	private InstructorConverter insConverter;
	
	@Autowired
	@Qualifier("eventosRepository")
	private EventosRepository evento;
	
	@Autowired
	@Qualifier("eventosConverter")
	private EventosConverter eveCon;
	
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

	@Override
	public void nuevoInstructor(InstructorModel instrucMod) {
		Users usu=alumnoUserConverter.converterInstructorModelToUser(instrucMod);
		userRepo.saveAndFlush(usu);
		LOG.info("EL USUARIO DEL INSTRUCTOR SE GUARDO");
		UserRole rolusu= alumnoUserConverter.converterInstructorModelToUserRole(instrucMod);
		rolerepo.saveAndFlush(rolusu);
		LOG.info("EL ROL DEL USUARIO DEL INSTRUCTOR SE GUARDO EXITOSAMENTE");
		Instructor in=alumnoUserConverter.converterInstructorModelToIntructor(instrucMod);
		instrurepo.saveAndFlush(in);
		
	}

	@Override
	public List<CursoModel> listaCursos() {
		List<Cursos> cur=cursorepo.findAll();
		List<CursoModel> curmo= new ArrayList<CursoModel>();
		for(Cursos cu : cur) {
			curmo.add(curconver.convertCursoToCursoModel(cu));
			
		}
		LOG.info("LISTA DE CURSO ***");
		return curmo;
	}

	@Override
	public List<InstructorModel> listaIntructores() {
		List<Instructor> ins=instrurepo.findAll();
		List<InstructorModel> inmod = new ArrayList<InstructorModel>();
		for(Instructor in: ins) {
			inmod.add(insConverter.converterEntityToModel(in));
		}
		LOG.info("Lista de Instructores Instructor *******");
		return inmod;
	}

	@Override
	public void nuevoEvento(EventosModel evemod) {
		Eventos even= eveCon.convertEventoModelToEvento(evemod);
		evento.saveAndFlush(even);
		LOG.info("El evento se ha guardado correctamente ----------");
		
	}
	
	

}
