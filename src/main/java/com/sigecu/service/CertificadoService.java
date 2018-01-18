package com.sigecu.service;

import java.util.List;
import java.util.Map;

import com.sigecu.entity.Certificado;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.CertificadoModel;

public interface CertificadoService {

	public abstract List<CertificadoModel> lisAllCertificados() throws BusinessException;

	public abstract Certificado findCertificadoById(int idCertificado) throws BusinessException;
	
	public List<Map<String, Object>> report() throws BusinessException;
	
	public List<Map<String, Object>> report(int idCertificado) throws BusinessException;
	
	public Iterable<Certificado> findAll() throws BusinessException;

	List<Map<String, Object>> report(int id_alumno, int id_evento) throws BusinessException;
}
