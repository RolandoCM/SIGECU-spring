/**
 * 
 */
package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Cursos;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 17/12/2017
 *
 */
@Repository("cursoRepository")
public interface CursosRepository extends JpaRepository<Cursos, Serializable> {
	//nusca curso por idCurso
	public abstract Cursos findByIdCurso(int idCurso);

}
