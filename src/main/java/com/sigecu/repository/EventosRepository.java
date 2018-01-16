package com.sigecu.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Eventos;
import com.sigecu.entity.Instructor;

@Repository("eventosRepository")
public interface EventosRepository extends JpaRepository <Eventos, Serializable>{
	
	public abstract List<Eventos> findByInstructor (Instructor instructor);
	public abstract Eventos findByIdEvento(int idEvento);
}
