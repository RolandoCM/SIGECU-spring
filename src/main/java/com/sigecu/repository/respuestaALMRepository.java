package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.RespuestaALMEntity;

@Repository("respuestasALMRepository")
public interface respuestaALMRepository  extends JpaRepository<RespuestaALMEntity,Serializable>{
	public abstract RespuestaALMEntity findByIdPregunta(int idPregunta);
}
