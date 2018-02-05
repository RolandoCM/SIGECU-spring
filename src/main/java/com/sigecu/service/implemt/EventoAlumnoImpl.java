package com.sigecu.service.implemt;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.EvaluacionConverter;
import com.sigecu.converter.EventosConverter;
import com.sigecu.entity.Cursos;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.entity.Eventos;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.EventosModel;
import com.sigecu.repository.CursosRepository;
import com.sigecu.repository.EvaluacionRepository;
import com.sigecu.repository.EventosRepository;
import com.sigecu.repository.QueryEvaluacion;
import com.sigecu.repository.QueryEventoAlumno;
import com.sigecu.service.eventoAlumnoService;

@Service("eventoAlumnoImpl")
public class EventoAlumnoImpl implements eventoAlumnoService{
	private static final Log LOG=LogFactory.getLog(EventoAlumnoImpl.class);
	
    @Autowired 
	@Qualifier("eventosRepository")
     private EventosRepository eventosAlumnoRepository;
    @Autowired
    @Qualifier("evaluacionesRepository")
    private EvaluacionRepository evaluacionesRepository;
    @Autowired
    @Qualifier("eventosConverter")
    private EventosConverter eventosConverter;
    
    @Autowired
    @Qualifier("queryEventoAlumno")
    private QueryEventoAlumno queryEventoAlumno;
    
    @Autowired
    @Qualifier("cursoRepository")
    private CursosRepository cursosRepository;
    
    @Autowired
    @Qualifier("queryEvaluacion")
    private QueryEvaluacion queryEvaluacion;
    
    @Autowired
    @Qualifier("evalaucionesConverter")
    private EvaluacionConverter evaluacionesConverter;

	@Override
	public List<EventosModel> listAllEventosAl(int idAlumno) {
		List<Eventos> eventos = queryEventoAlumno.findAllEventosAlumnosById(idAlumno);
		List<EventosModel> eventosModel=new ArrayList<EventosModel>();
		
		for(Eventos evento: eventos) {
			eventosModel.add(eventosConverter.convertEventoToEentoModel(evento));
		}
		LOG.info("Eventos" + idAlumno);
		
		//LOG.info("FECHA" + eventosModel.get(1).geteFechaInicio());
		return eventosModel;
	}

	@Override
	public List<AlumnoModel> listaAlumnos() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.eventoAlumnoService#listAllExamen(int, int)
	 */
	@Override
	public List<EvaluacionesModel> listAllExamen(int idAlumno, int idEvento) {
		Eventos evento = queryEventoAlumno.findAllEventosByID(idEvento);
		Cursos curso = evento.getCursosEvento();
		List<Evaluaciones> listEvaluaciones = queryEvaluacion.findAllExamenesById(curso.getIdCurso());
		List<EvaluacionesModel> listEvalModel = new ArrayList<>();
		for(Evaluaciones evaluacion : listEvaluaciones) {
			EvaluacionesModel evalModel = evaluacionesConverter.convertEvaluacion2EvaluacionModel(evaluacion);
			listEvalModel.add(evalModel);
			LOG.info("EXAMEN AGREGADO: "+evalModel.geteNombre());
		}
		return listEvalModel;
	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.eventoAlumnoService#validarcertificado(int, int)
	 */
	@Override
	public int validarcertificado(int idAlumno, int idEvento) {
		String status = null;
		int v = 0;
		
		status = queryEventoAlumno.validarCertificado(idEvento, idAlumno).getStatus();
 		if(status == null || status.equals("")) {
 			v=0;
 		}else {
 			v=1;
 		}
		LOG.info("Estatus evento: "+status+" ;");
 		return v;
	}

    
}
