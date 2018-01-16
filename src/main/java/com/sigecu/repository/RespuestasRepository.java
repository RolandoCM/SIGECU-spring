/**
 * 
 */
package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sigecu.entity.Respuestas;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 19/12/2017
 *
 */
@Repository("respuestasRepository")
public interface RespuestasRepository extends JpaRepository<Respuestas, Serializable> {
	public abstract Respuestas findByIdRespuesta(int idRespuesta);
}
