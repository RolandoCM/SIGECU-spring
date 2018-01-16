package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.repository.AlumnoHasEventoRepository;
import com.sigecu.repository.QueryAlumnoHasEvento;
import com.sigecu.repository.QueryEvaluacion;
import com.sigecu.service.AlumnoHasEventoService;

@Service("alumnoHasEventoServiceImpl")
public class AlumnoHasEventoServiceImpl implements AlumnoHasEventoService {
	private static final Log LOG = LogFactory.getLog(QueryEvaluacion.class);
	@Autowired
	@Qualifier("alumnoHasEventoRepository")
	private AlumnoHasEventoRepository alumnoHasEventoRepository;
	@Autowired
	@Qualifier("queryAlumnoHasEvento")
	private QueryAlumnoHasEvento queryAlumnoHasEvento;
	
	@Override
	public Alumno_Has_Eventos findAlumnoHasEventoById(int idAHE) {
		return null; // alumnoHasEventoRepository.findAlumnoHasEventoByIdAHE(idAHE);
	}

	@Override
	public void findAlumnoHasEventoByIdAlumnoAndIdEvento(int id_alumno, int id_evento) {
		Tuple result = queryAlumnoHasEvento.findAlumnoHasEventosByIdAlumnoAndIdEvento(id_alumno, id_evento);
		LOG.info("Papu :v "+ result);
	}
	
	@Override
	public List<Map<String, Object>>  report(int id_alumno, int id_evento) {
		
		Tuple datos = queryAlumnoHasEvento.findAlumnoHasEventosByIdAlumnoAndIdEvento(id_alumno, id_evento);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> item= new HashMap<String, Object>();
		item.put("alumno",datos.get(0, null)+" "+datos.get(1, null)+" "+datos.get(2, null));
		item.put("curso", datos.get(3, null));
		item.put("fecha", datos.get(4, null));
		
		result.add(item);
		
		return result;
	}
	
}
