/**
 * 
 */
package com.sigecu.service.implemt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.AsignaExamenConverter;
import com.sigecu.entity.Alumno_Has_Eventos;
import com.sigecu.entity.AsignaExamenEntity;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.repository.QueryAlumnoHasEvento;
import com.sigecu.service.ValidarExamenAlumnoService;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 13/01/2018
 *
 */
@Service("validarRealizarExamen")
public class ValidaRealizarExamenServiceImpl implements ValidarExamenAlumnoService {

	@Autowired
	@Qualifier("queryAlumnoHasEvento")
	private QueryAlumnoHasEvento queryAlumnoHasEvento;
	
	@Autowired
	@Qualifier("asignaExamenConverter")
	private AsignaExamenConverter asignaExamenConverter;

	private static final Log LOG = LogFactory.getLog(ValidaRealizarExamenServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sigecu.service.ValidarExamenAlumnoService#validaRealizarExamen(int,
	 * int, int)
	 */
	@Override
	public boolean validaRealizarExamen(int idEvaluacion, int idAlumno, int idEvento) throws BusinessException {
		try {
			Alumno_Has_Eventos aHE = queryAlumnoHasEvento.findAlumnoHasEvento(idAlumno, idEvento);
			LOG.info("ID ALUMNO: " + aHE.getAlumno().getIdAlumno() + " ID EVENTO: " + aHE.getEvntos().getIdEvento()
					+ " ASIGNA EXAMEN: " + aHE.getAsignaExamen().getIdasignaExamen());
			LOG.info("ACTIVO: " + aHE.getAsignaExamen().getAsignado());
			if (aHE.getAsignaExamen().getAsignado().equals("1") && aHE.getAsignaExamen().getRealizado().equals("0")) {
				return true;
			} else {
				return false;
			}
		} catch (BusinessException e) {
			LOG.error("NO SE EJECUTO EL METODO");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE");
			throw be;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sigecu.service.ValidarExamenAlumnoService#validaSegundaOportunidadExamen(
	 * int, int, int) validar realizar en segunda oportunidad el examen
	 */
	@Override
	public boolean validaSegundaOportunidadExamen(int idEvaluacion, int idAlumno, int idEvento)
			throws BusinessException {
		try {
			Alumno_Has_Eventos aHE = queryAlumnoHasEvento.findAlumnoHasEvento(idAlumno, idEvento);
			LOG.info("ID ALUMNO: " + aHE.getAlumno().getIdAlumno() + " ID EVENTO: " + aHE.getEvntos().getIdEvento()
					+ " ASIGNA EXAMEN: " + aHE.getAsignaExamen().getIdasignaExamen());
			LOG.info("ACTIVO: " + aHE.getAsignaExamen().getAsignado());
			/*
			 * se valida que el examen asignado al alumno = 1 (si) realizado 1 = ya se
			 * realizo status 0 = reporbado
			 */
			if (aHE.getAsignaExamen().getAsignado().equals("1") && aHE.getAsignaExamen().getRealizado().equals("1")
					&& aHE.getAsignaExamen().getStatus().equals("0")) {
				return true;
			} else {
				return false;
			}
		} catch (BusinessException e) {
			LOG.error("NO SE EJECUTO EL METODO");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE");
			throw be;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sigecu.service.ValidarExamenAlumnoService#validaMostrarRetroalimentarcion
	 * (int, int, int)
	 */
	@Override
	public boolean validaMostrarRetroalimentarcion(int idEvaluacion, int idAlumno, int idEvento)
			throws BusinessException {
		try {
			Alumno_Has_Eventos aHE = queryAlumnoHasEvento.findAlumnoHasEvento(idAlumno, idEvento);
			LOG.info("ID ALUMNO: " + aHE.getAlumno().getIdAlumno() + " ID EVENTO: " + aHE.getEvntos().getIdEvento()
					+ " ASIGNA EXAMEN: " + aHE.getAsignaExamen().getIdasignaExamen());
			LOG.info("ACTIVO: " + aHE.getAsignaExamen().getAsignado());
			if (aHE.getAsignaExamen().getAsignado().equals("0") && 
					aHE.getAsignaExamen().getRealizado().equals("1")) {
				return true;
			} else {
				return false;
			}
		} catch (BusinessException e) {
			LOG.error("NO SE EJECUTO EL METODO");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE");
			throw be;
		}
	}

	/* (non-Javadoc)
	 * @see com.sigecu.service.ValidarExamenAlumnoService#asignarExamen(int, int)
	 */
	@Override
	public AsignaExamenModel asignarExamen(int idAlumno, int idEvento) throws BusinessException {
		try {
			Alumno_Has_Eventos aHE = queryAlumnoHasEvento.findAlumnoHasEvento(idAlumno, idEvento);
			LOG.info("AHE DE ASIGNA EXAMEN: "+ aHE.toString());
			AsignaExamenEntity asignaExamen = aHE.getAsignaExamen();
			AsignaExamenModel asignaExamenModel = asignaExamenConverter.converterAsignaExamenToAsignaExamenModel(asignaExamen);
			return asignaExamenModel;
		} catch (BusinessException e) {
			LOG.error("NO SE EJECUTO EL METODO");
			throw e;

		} catch (Exception e) {
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE");
			throw be;
		}
	}

}
