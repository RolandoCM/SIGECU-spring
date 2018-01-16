/**
 * 
 */
package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sigecu.converter.CursosConverter;
import com.sigecu.entity.Cursos;
import com.sigecu.model.CursoModel;
import com.sigecu.repository.CursosRepository;
import com.sigecu.service.AlumnosPerfilService;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 20/12/2017
 *
 */
@Service("alumnosPerfilService")
public class AlumnosPerfilServiceImplemet implements AlumnosPerfilService {

	@Autowired
	@Qualifier("cursoRepository")
	private CursosRepository cursosRepository;
	
	@Autowired
	@Qualifier("cursosConvertir")
	private CursosConverter cursosConverter;
	
	
	/* (non-Javadoc)
	 * @see com.sigecu.service.AlumnosPerfilService#listaCursosParaAlumno()
	 */
	@Override
	public List<CursoModel> listaCursosParaAlumno() {
		List<Cursos> cursos = cursosRepository.findAll();
		List<CursoModel> cursoModel = new ArrayList<>();
		
		for(Cursos curso : cursos) {
			cursoModel.add(cursosConverter.convertCursoToCursoModel(curso));
		}
		return cursoModel;
	}
	
}
