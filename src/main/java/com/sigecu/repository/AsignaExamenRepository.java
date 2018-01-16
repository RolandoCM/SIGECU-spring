/**
 * 
 */
package com.sigecu.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sigecu.entity.AsignaExamenEntity;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/01/2018
 *
 */
@Repository("asignaExamenRepository")
public interface AsignaExamenRepository extends JpaRepository<AsignaExamenEntity, Serializable>{
	public abstract AsignaExamenEntity findByIdasignaExamen(int idasignaExamen);

}
