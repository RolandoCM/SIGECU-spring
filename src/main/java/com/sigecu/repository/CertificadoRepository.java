package com.sigecu.repository;


import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Certificado;

@Repository("certificadoRepository")
public interface CertificadoRepository extends JpaRepository<Certificado, Serializable> {
	public abstract Certificado findByIdCertificado(int idCertificado);
}
