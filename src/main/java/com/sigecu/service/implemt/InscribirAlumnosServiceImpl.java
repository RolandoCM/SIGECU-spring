package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.component.CrearAsignaExamenComponent;
import com.sigecu.converter.AltaAlumnosConverter;
import com.sigecu.converter.AlumnosConverter;
import com.sigecu.converter.AsignaExamenConverter;
import com.sigecu.converter.EventosConverter;
import com.sigecu.entity.Alumno;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Eventos;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AltaAlumnoModel;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.model.EventosModel;
import com.sigecu.repository.AlumnoHasEventoRepository;
import com.sigecu.repository.AlumnoRepository;
import com.sigecu.repository.AsignaExamenRepository;
import com.sigecu.repository.EventosRepository;
import com.sigecu.service.InscribirAlumnosService;

@Service("inscribirAlumnoService")
public class InscribirAlumnosServiceImpl implements InscribirAlumnosService{

	@Autowired
	@Qualifier("alumnoRepository")
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	@Qualifier("alumnosConverter")
	private AlumnosConverter alumnosConverter;
	
	@Autowired
	@Qualifier("eventosRepository")
	private EventosRepository eventosRepository;
	
	@Autowired
	@Qualifier("eventosConverter")
	private EventosConverter eventosConverter;
	
	@Autowired
	@Qualifier("crearAsignaExamenComponent")
	private CrearAsignaExamenComponent crearAsignaExamenComponenct;
	
	@Autowired
	@Qualifier("asignaExamenRepository")
	private AsignaExamenRepository asignaExamenRepository;
	@Autowired
	@Qualifier("asignaExamenConverter")
	private AsignaExamenConverter asignaExamenConverter;
	@Autowired
	@Qualifier("altaAlumnosConverter")
	private AltaAlumnosConverter altaAlumnosConverter;
	@Autowired
	@Qualifier("alumnoHasEventoRepository")
	private AlumnoHasEventoRepository alumnoHasEventoRepository;
	/*
	 * Buscar alumnos registrados en el sistema para alta en evento*/
	@Override
	public List<AlumnoModel> alumnosAll() throws BusinessException{
		try {
			List<Alumno> alumnos = alumnoRepository.findAll();
			List<AlumnoModel> alumnosModel = new ArrayList<>();
			for(Alumno alumno : alumnos) {
				alumnosModel.add(alumnosConverter.converterAlumnoToAlumnoModel(alumno));
			}
			return alumnosModel;
		}catch(Exception e) {
			BusinessException be = new BusinessException();
			be.setIdException(200);
			be.setMsj("ERROR EN SERVICE : verifique la busqueda de alumnos ");
			throw be;
		}
		
	}

	/*
	 * Buscar eventos para alta en evento alumno*/
	@Override
	public List<EventosModel> eventosAll() throws BusinessException {
		try {
			List<Eventos> eventos = eventosRepository.findAll();
			List<EventosModel> eventosModel = new ArrayList<>();
			for(Eventos evento : eventos) {
				eventosModel.add(eventosConverter.convertEventoToEentoModel(evento));
			}
			return eventosModel;
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.setIdException(200);
			be.setMsj("ERROR SERVICE : verifique busqueda de eventos ");
			be.printStackTrace();
			throw be;
		}
	}

	@Override
	public void altaAlumnoAEvento(AltaAlumnoModel altaAE) {
		
		AsignaExamenModel asignaExamenModel = crearAsignaExamenComponenct.crearAsignaExamen();
		AsignaExamenEntity asignaExamen = asignaExamenConverter.converterAsignaExamenModelToAsignaExamenEntity(asignaExamenModel);
		Alumno_Has_Eventos ahe =altaAlumnosConverter.converterAltaAlumnoToAheEntity(altaAE, asignaExamen);
		asignaExamenRepository.save(ahe.getAsignaExamen());
		alumnoHasEventoRepository.save(ahe);
		//
		
		
		
		
	}
	
}
