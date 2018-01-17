/**
 * 
 */
package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.model.AsignaExamenModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/01/2018
 *
 */
@Component("asignaExamenConverter")
public class AsignaExamenConverter {
	private static final Log LOG = LogFactory.getLog(AsignaExamenConverter.class);
	
	public AsignaExamenModel converterAsignaExamenToAsignaExamenModel(AsignaExamenEntity asignaExamen) {
		AsignaExamenModel asignaExamenModel = new AsignaExamenModel();
		
		asignaExamenModel.setIdasignaExamen(asignaExamen.getIdasignaExamen());
		asignaExamenModel.setAsignado(asignaExamen.getAsignado());
		asignaExamenModel.setFechaFin(asignaExamen.getFechaFin());
		asignaExamenModel.setFechaInicio(asignaExamen.getFechaInicio());
		asignaExamenModel.setHorafin(asignaExamen.getHorafin());
		asignaExamenModel.setHoraInicio(asignaExamen.getHoraInicio());
		asignaExamenModel.setRealizado(asignaExamen.getRealizado());
		asignaExamenModel.setStatus(asignaExamen.getStatus());
		
		return asignaExamenModel;
	}
	
	public AsignaExamenEntity converterAsignaExamenModelToAsignaExamenEntity(AsignaExamenModel asignaModel) {
		AsignaExamenEntity asignaExamen = new AsignaExamenEntity();
		asignaExamen.setFechaInicio(asignaModel.getFechaInicio());
		asignaExamen.setFechaFin(asignaModel.getFechaFin());
		asignaExamen.setAsignado(asignaModel.getAsignado());
		asignaExamen.setIdasignaExamen(asignaModel.getIdasignaExamen());
		return asignaExamen;
	}
}
