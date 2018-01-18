package com.sigecu.component;

import org.springframework.stereotype.Component;

import com.sigecu.model.AsignaExamenModel;

@Component("crearAsignaExamenComponent")
public class CrearAsignaExamenComponent {
	
	public AsignaExamenModel crearAsignaExamen () {
		
		AsignaExamenModel asignaExamen = new AsignaExamenModel();
		
		asignaExamen.setFechaInicio(null);
		asignaExamen.setFechaFin(null);
		asignaExamen.setAsignado("0");
		asignaExamen.setHoraInicio(null);
		asignaExamen.setHorafin(null);
		asignaExamen.setRealizado("0");
		asignaExamen.setStatus("0");
		return asignaExamen;
		
	}
}
