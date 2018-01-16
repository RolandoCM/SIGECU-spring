/**
 * 
 */
package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.Instructor;
import com.sigecu.entity.Users;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Repository("instructorRepository")
public interface InstructorRepository extends JpaRepository<Instructor, Serializable>{
	
	public abstract Instructor findByUser(Users user);
	public abstract Instructor findByIdInstructor(int idInstructor);

}
