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
	public EvaluacionesModel convertEvaluacion2EvaluacionModel(Evaluaciones evaluacion) {
		EvaluacionesModel eval = new EvaluacionesModel();

		CursoModel curso = cursosConverter.convertCursoToCursoModel(evaluacion.getCursos());
		eval.setIdevaluacion(evaluacion.getIdEvaluacion());
		eval.setCurso(curso);
		eval.seteNombre(evaluacion.geteNombre());
		eval.setePorcentaje(evaluacion.getePorsentaje());
		eval.seteTiempo(evaluacion.geteTiempo());
		LOG.info("convierte el entity a Model");

		return eval;

	}

	// Model --> Entity
	public Evaluaciones convertEvaluacionModelToEvaluacion(EvaluacionesModel evaluacionModel, Cursos curso) {
		Evaluaciones evaluacion = new Evaluaciones();

		evaluacion.seteNombre(evaluacionModel.geteNombre());
		evaluacion.setePorsentaje(evaluacionModel.getePorcentaje());
		evaluacion.setCursos(curso);
		evaluacion.seteTiempo(evaluacionModel.geteTiempo());
		return evaluacion;
	}
}
