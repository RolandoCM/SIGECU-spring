package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.CursosConverter;
import com.sigecu.converter.EventosConverter;
import com.sigecu.converter.InstructorConverter;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Instructor;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.model.InstructorModel;
import com.sigecu.repository.CursosRepository;
import com.sigecu.repository.EventosRepository;
import com.sigecu.repository.InstructorRepository;
import com.sigecu.service.AdminEventoService;
import org.apache.commons.logging.Log;

@Service("adminEventoServiceImpl")
public class AdminEventoServiceImpl implements AdminEventoService {
	private static final Log LOG=LogFactory.getLog(AdminEventoServiceImpl.class);
	
	@Autowired
	@Qualifier("eventosRepository")
	private EventosRepository eventosRepository;
	
	@Autowired
	@Qualifier("eventosConverter")
	private EventosConverter eventosConverter;
	
	@Autowired
	@Qualifier("cursoRepository")
	private CursosRepository cursoRepository;
	
	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter cursosConverter;
	
	@Autowired
	@Qualifier("instructorConverter")
	private InstructorConverter instructorConverter;
	
	@Autowired
	@Qualifier("instructorRepository")
	private InstructorRepository instructorRepository;
	
	
	
	
	

	@Override
	public List<CursoModel> listaCursos() {
		List<Cursos> cursos = cursoRepository.findAll();
		List<CursoModel> cursoModel = new ArrayList<CursoModel>();
		for (Cursos curso : cursos) {
			cursoModel.add(cursosConverter.convertCursoToCursoModel(curso));
		}
		return cursoModel;
	}

	@Override
	public List<InstructorModel> listaInstructor() {
		List<Instructor> instructor= instructorRepository.findAll();
		List<InstructorModel> instructorModel=new ArrayList<InstructorModel>();
		for(Instructor inst: instructor) {
			instructorModel.add(instructorConverter.converterEntityToModel(inst));
			
		}
		return instructorModel;
	}

	@Override
	public void nuevoEvento(EventosModel eventoModel, int idCurso, int idInstructor) {
		Cursos curso = cursoRepository.findByIdCurso(idCurso);
		Instructor instructor= instructorRepository.findByIdInstructor(idInstructor);		
		Eventos even=eventosConverter.convertEventoModelToEvento(eventoModel, curso, instructor);
		
		
	}

}
