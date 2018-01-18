/**
 * 
 */
package com.sigecu.converter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import com.sigecu.entity.Cursos;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.CursoModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 17/12/2017
 *
 */
@Component("cursosConvertir")
public class CursosConverter {
	private static final Log LOG = LogFactory.getLog(CursosConverter.class);

	// entity -- to -- model
	public CursoModel convertCursoToCursoModel(Cursos curso) throws BusinessException{
		CursoModel cursoModel = new CursoModel();
		try {
			cursoModel.setIdCurso(curso.getIdCurso());
			cursoModel.setcNombre(curso.getcNombre());
			cursoModel.setcDescripcion(curso.getcDescripcion());

		}
		catch(Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE : Error convertir Curso a CursoModel");
			throw be;
		}
		
		return cursoModel;
	}

	// model -- to -- entity
	public Cursos convertCursoModelToCurso(CursoModel cursoModel) throws BusinessException {
		Cursos curso = new Cursos();
		try {
			curso.setcNombre(cursoModel.getcNombre());
			curso.setcDescripcion(cursoModel.getcDescripcion());
			
		} catch (Exception e) {
			LOG.error("NO SE EJECUTO EL METODO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Error en convertir el cursoModel a curso");
			throw be;
		}
		return curso;
	}
}
