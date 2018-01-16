/**
 * 
 */
package com.sigecu.repository;

import org.springframework.stereotype.Repository;

import com.sigecu.entity.Users;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Serializable>{
	public abstract Users findByUsername(String username);
}
