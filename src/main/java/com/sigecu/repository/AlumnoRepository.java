/**
 * 
 */
package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Alumno;
import com.sigecu.entity.Users;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Repository("alumnoRepository")
public interface AlumnoRepository extends JpaRepository<Alumno, Serializable> {
	
	public abstract Alumno findByUser(Users user);
	public abstract Alumno findByIdAlumno( int idAlumno);

}
