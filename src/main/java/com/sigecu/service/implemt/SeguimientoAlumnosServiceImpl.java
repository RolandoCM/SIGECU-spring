package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.AlumnosConverter;
import com.sigecu.converter.AsignaExamenConverter;
import com.sigecu.converter.EvaluacionConverter;
import com.sigecu.entity.Alumno;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Eventos;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.repository.AlumnoRepository;
import com.sigecu.repository.AsignaExamenRepository;
import com.sigecu.repository.EventosRepository;
import com.sigecu.repository.QueryAlumnoHasEvento;
import com.sigecu.service.SeguimientoAlumnoService;

@Service("seguimientoAlumnoService")
public class SeguimientoAlumnosServiceImpl implements SeguimientoAlumnoService {
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
	@Qualifier("evalaucionesConverter")
	private EvaluacionConverter evaluacionConverter;
	@Autowired
	@Qualifier("queryAlumnoHasEvento")
	private QueryAlumnoHasEvento queryAlumnoHasEvento;
	
	@Autowired
	@Qualifier("CalificacionImplement")
	private CalificacionImplement calificacionService;
	@Autowired
	@Qualifier("asignaExamenConverter")
	private AsignaExamenConverter asignaExamenConverter;
	@Autowired
	@Qualifier("asignaExamenRepository")
	private AsignaExamenRepository asignaExamenRepository;
	
	private static final Log LOG = LogFactory.getLog(SeguimientoAlumnosServiceImpl.class);
	/*
	 * Busca el alumno 
	 * */
	@Override
	public AlumnoModel findAlumno(int idAlumno) throws BusinessException{
		try {
			Alumno alumno = alumnoRepository.findByIdAlumno(idAlumno);
			AlumnoModel alumnoModel = alumnosConverter.converterAlumnoToAlumnoModel(alumno);
			return alumnoModel;
		}catch(Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.setIdException(200);
			be.setMsj("SERVICE : ocurrio un error en buscar el alumno");
			throw be;
		}
		
	}

	@Override
	public List<Object> datosAlumno(AlumnoModel alumnoModel, int idEvento) throws BusinessException {
		List<Object> datos = new ArrayList<>();
		Eventos evento = eventosRepository.findByIdEvento(idEvento);
		Set<Evaluaciones> evaluaciones = evento.getCursosEvento().getEvaluaciones();
		Evaluaciones evaluacion = evaluaciones.iterator().next();
		EvaluacionesModel evaluacionModel = evaluacionConverter.convertEvaluacion2EvaluacionModel(evaluacion);
		
		/*buscar el asigna evento*/
		Alumno_Has_Eventos alumnoHasEventos = queryAlumnoHasEvento.findAlumnoHasEvento(alumnoModel.getId_alumno(), idEvento);
		LOG.info("ALUMNOS_HAS_EVENTOS: "+alumnoHasEventos.getAsignaExamen().getIdasignaExamen()+" ALUMNO: "+alumnoHasEventos.getAlumno().getIdAlumno());
		AsignaExamenEntity asignaExamen = alumnoHasEventos.getAsignaExamen();
		AsignaExamenModel asignaExamenModel = asignaExamenConverter.converterAsignaExamenToAsignaExamenModel(asignaExamen);
		double [] examen = calificacionService.calificacionFnl(evaluacion.getIdEvaluacion(), asignaExamen.getIdasignaExamen());
		LOG.info("CALIFICACION: "+examen[0]);
		datos.add(evaluacionModel);
		datos.add(examen);
		datos.add(asignaExamenModel);
		
		return datos;
	}

	@Override
	public boolean activarExamenAlumno(int idAsignaExamen, AsignaExamenModel asignaExamen) throws BusinessException {
		try {
			AsignaExamenEntity asignaOld = asignaExamenRepository.findByIdasignaExamen(idAsignaExamen);
			asignaExamen.setIdasignaExamen(idAsignaExamen);
			asignaExamen.setStatus("0");
			LOG.info("ID de asignaEXAMEN: "+ idAsignaExamen);
			LOG.info(asignaOld.toString());
			if((asignaOld.getRealizado() == null)|| (asignaOld.getRealizado().equals("0") )) 
				asignaExamen.setRealizado("0");
			else
				asignaExamen.setRealizado("1");
				
			LOG.info(asignaExamen.toString());
			AsignaExamenEntity asignaEntity =asignaExamenConverter.converterAsignaExamenModelToAsignaExamenEntity(asignaExamen);
			asignaExamenRepository.save(asignaEntity);
		}catch(Exception e) {
			e.printStackTrace();
			LOG.error("ERROR CAPA DE SERVICE: ");
		}
		return false;
	}

}
