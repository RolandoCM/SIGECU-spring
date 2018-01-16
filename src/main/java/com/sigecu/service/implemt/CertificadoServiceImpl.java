package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.querydsl.core.Tuple;
import com.sigecu.converter.CertificadoConverter;
import com.sigecu.entity.Certificado;
import com.sigecu.model.CertificadoModel;
import com.sigecu.repository.CertificadoRepository;
import com.sigecu.repository.QueryAlumnoHasEvento;
import com.sigecu.service.CertificadoService;

@Service("certificadoServiceImpl")
public class CertificadoServiceImpl implements CertificadoService{
	
	@Autowired
	@Qualifier("certificadoRepository")
	private CertificadoRepository certificadoRepository;
	@Autowired
	@Qualifier("certificadoConverter")
	private CertificadoConverter certificadoConverter;
	@Autowired
 	@Qualifier("queryAlumnoHasEvento")
 	private QueryAlumnoHasEvento queryAlumnoHasEvento;
	
	@Override
	public List<CertificadoModel> lisAllCertificados() {
		List<Certificado> certificados = certificadoRepository.findAll();
		List<CertificadoModel> certificadosModel = new ArrayList<CertificadoModel>();
		for(Certificado certificado:certificados) {
			certificadosModel.add(certificadoConverter.convertCertificadoToCertificadoModel(certificado));
		}
		return certificadosModel;
	}

	@Override
	public Certificado findCertificadoById(int idCertificado) {
		return certificadoRepository.findByIdCertificado(idCertificado);
	}

	@Override
	public List<Map<String, Object>> report() {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(Certificado certificado : this.findAll()) {
			Map<String, Object> item= new HashMap<String, Object>();
			item.put("alumno", certificado.getAlumno());
			
			result.add(item);
		}
		return result;
	}
	
	@Override
	public List<Map<String, Object>>  report(int idCertificado) {
		
		Certificado certificado = certificadoRepository.findByIdCertificado(idCertificado);
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> item= new HashMap<String, Object>();
		item.put("alumno", certificado.getAlumno());
		item.put("curso", certificado.getCurso());
		item.put("fecha", certificado.getFecha());
		
		result.add(item);
		
		return result;
		
	}

	@Override
	public Iterable<Certificado> findAll() {
		return certificadoRepository.findAll();
	}
	
	
	@Override
	public List<Map<String, Object>>  report(int id_alumno, int id_evento) {
		
		Tuple datos = queryAlumnoHasEvento.findAlumnoHasEventosByIdAlumnoAndIdEvento(id_alumno, id_evento);
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> item= new HashMap<String, Object>();
		item.put("alumno",datos.get(0, null));
		item.put("curso", datos.get(1, null));
		item.put("fecha", datos.get(2, null));
		
		result.add(item);
		
		return result;
	}
	

}
