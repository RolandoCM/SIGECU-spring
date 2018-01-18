/**
 * 
 */
package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Cursos;
import com.sigecu.entity.Evaluaciones;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.CursoModel;
import com.sigecu.model.EvaluacionesModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 14/12/2017
 *
 */
@Component("evalaucionesConverter")
public class EvaluacionConverter {

	private static final Log LOG = LogFactory.getLog(EvaluacionConverter.class);
	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter cursosConverter;

	// Entity --> Model
	public EvaluacionesModel convertEvaluacion2EvaluacionModel(Evaluaciones evaluacion) throws BusinessException{
		EvaluacionesModel eval = new EvaluacionesModel();
		
		try {
			
		CursoModel curso = cursosConverter.convertCursoToCursoModel(evaluacion.getCursos());
		eval.setIdevaluacion(evaluacion.getIdEvaluacion());
		eval.setCurso(curso);
		eval.seteNombre(evaluacion.geteNombre());
		eval.setePorcentaje(evaluacion.getePorsentaje());
		eval.seteTiempo(evaluacion.geteTiempo());
		LOG.info("convierte el entity a Model");
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			e.printStackTrace();
			BusinessException be = new BusinessException();
			be.setIdException(001);
			be.setMsj("ERROR EN CONVERTER: Convertir evaluacion a EvaluacionModel ");
			throw be;
		}
		return eval;

	}

	// Model --> Entity
	public Evaluaciones convertEvaluacionModelToEvaluacion(EvaluacionesModel evaluacionModel, Cursos curso) throws BusinessException{
		Evaluaciones evaluacion = new Evaluaciones();

		try {
			evaluacion.seteNombre(evaluacionModel.geteNombre());
			evaluacion.setePorsentaje(evaluacionModel.getePorcentaje());
			evaluacion.setCursos(curso);
			evaluacion.seteTiempo(evaluacionModel.geteTiempo());
		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Convertir EvaluacionModel a Evaluacion");
			throw be;
		
		}
		
		return evaluacion;
	}
}
