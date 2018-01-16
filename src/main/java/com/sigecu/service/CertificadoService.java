package com.sigecu.service;

import java.util.List;
import java.util.Map;

import com.sigecu.entity.Certificado;
import com.sigecu.model.CertificadoModel;

public interface CertificadoService {

	public abstract List<CertificadoModel> lisAllCertificados();

	public abstract Certificado findCertificadoById(int idCertificado);
	
	public List<Map<String, Object>> report();
	
	public List<Map<String, Object>> report(int idCertificado);
	
	public Iterable<Certificado> findAll();

	List<Map<String, Object>> report(int id_alumno, int id_evento);
}
