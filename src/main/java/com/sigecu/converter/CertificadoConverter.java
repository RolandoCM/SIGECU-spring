package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Certificado;
import com.sigecu.model.CertificadoModel;

@Component("certificadoConverter")
public class CertificadoConverter {
	
	private static final Log LOG = LogFactory.getLog(CertificadoConverter.class);
	
	//entity -- to -- model
	public CertificadoModel convertCertificadoToCertificadoModel(Certificado certificado) {
		CertificadoModel certificadoModel = new CertificadoModel();
		certificadoModel.setIdCertificado(certificado.getIdCertificado());
		certificadoModel.setAlumno(certificado.getAlumno());
		certificadoModel.setCurso(certificado.getCurso());
		certificadoModel.setCalificacion(certificado.getCalifiacion());
		certificadoModel.setFecha(certificado.getFecha());
		
		return certificadoModel;
	}
	
	//model -- to -- entity
	public Certificado convertCertificadoModelToCertificado(CertificadoModel certificadoModel) {
		Certificado certificado = new Certificado();
		certificado.setIdCertificado(certificadoModel.getIdCertificado());
		certificado.setAlumno(certificadoModel.getAlumno());
		certificado.setCurso(certificadoModel.getCurso());
		certificado.setCalifiacion(certificadoModel.getCalificacion());
		certificado.setFecha(certificadoModel.getFecha());
		
		return certificado;
	}
	
}
