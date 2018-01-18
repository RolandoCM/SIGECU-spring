/**
 * 
 */
package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.controller.InstructorController;
import com.sigecu.converter.AlumnosConverter;
import com.sigecu.converter.EventosConverter;
import com.sigecu.entity.Alumno;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.Eventos;
import com.sigecu.entity.Instructor;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.repository.EventosRepository;
import com.sigecu.repository.InstructorRepository;
import com.sigecu.service.InstructorService;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Service("instructorServiceImpl")
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	@Qualifier("eventosRepository")
	private EventosRepository eventoRepository;
	
	@Autowired
	@Qualifier("instructorRepository")
	private InstructorRepository instructorRepository;
	
	@Autowired
	@Qualifier("eventosConverter")
	private EventosConverter eventosConverter;
	
	@Autowired
	@Qualifier("alumnosConverter")
	private AlumnosConverter alumnosConverter;
	private static final Log LOG = LogFactory.getLog(InstructorServiceImpl.class);
	/* (non-Javadoc)
	 * @see com.sigecu.service.InstructorService#eventosPorInstructor(int)
	 */
	@Override
	public List<EventosModel> eventosPorInstructor(int idInstructor)throws BusinessException{
		Instructor instructor = instructorRepository.findByIdInstructor(idInstructor);
		List<Eventos> eventosEntity = eventoRepository.findByInstructor(instructor);
		List<EventosModel> eventosModel= new ArrayList<>();
		try {
		for(Eventos evento : eventosEntity) {
			EventosModel eventoModel = eventosConverter.convertEventoToEentoModel(evento);
			eventosModel.add(eventoModel);
		}
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be =  new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: NO SE ENCONTRARON EVENTOS");
			throw be;
		}
		return eventosModel;
	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.InstructorService#alumnosPorEvento(int)
	 */
	@Override
	public List<AlumnoModel> alumnosPorEvento(int idEvento) throws BusinessException {
		// TODO Auto-generated method stub
		Eventos evento = eventoRepository.findByIdEvento(idEvento);
		Set<Alumno_Has_Eventos> alumnosHasEventos = evento.getAlumnosHasEventos();
		Iterator<Alumno_Has_Eventos> iter = alumnosHasEventos.iterator();
		List<AlumnoModel> alumnosModel = new ArrayList<>();
		
		try {
		while(iter.hasNext()) {
			Alumno alumno = iter.next().getAlumno();
			AlumnoModel alumnoModel = alumnosConverter.converterAlumnoToAlumnoModel(alumno);
			alumnosModel.add(alumnoModel);
			//LOG.info("ALUMNO EN EVENTO: "+ iter.next().getAlumno().getaNombre());;
		}
	}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Lista vacia");
			throw be;
		}
		return alumnosModel;
	}

}
