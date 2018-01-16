package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Alumno_Has_Eventos;

@Repository("alumnoHasEventoRepository")
public interface AlumnoHasEventoRepository extends JpaRepository<Alumno_Has_Eventos, Serializable> {
	//public abstract Alumno_Has_Eventos buildByIdAlumno(int idAlumno);
}
