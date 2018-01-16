/**
 * 
 */
package com.sigecu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.PreguntasErradasConService;
import com.sigecu.service.ValidarExamenAlumnoService;

/**
 * @author JorgeLuna
 *
 */

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/preguntasErradas")
public class PreguntasErradasController {
	
	private static final Log LOG = LogFactory.getLog(PreguntasErradasController.class);
	private User user;
	AlumnoModel alumnoModel;
	
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;
	@Autowired
	@Qualifier("preErradasServiceImpl")
	private PreguntasErradasConService preguntasErradasConService;
	@Autowired
	@Qualifier("validarRealizarExamen")
	private ValidarExamenAlumnoService validaRealizarExamenAlumno;
	
//	@GetMapping("/cursos")
//	public ModelAndView Cursos() {
//		ModelAndView mav = new ModelAndView(ViewConstant.CURSOS_ALUMNO);
//		mav.addObject("listaCursosAl", preguntasErradasConService.listaCursos());
//		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
//		return mav;
//	}
//	
//	@GetMapping("/evaluaciones")
//	public ModelAndView evaluaciones(@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion) {
//		ModelAndView mav = new ModelAndView(ViewConstant.EXAMENES_ALUMNO);
//		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
//		mav.addObject("evaluacionesAlumno",preguntasErradasConService.listarEvaluaciones(idEvaluacion));		
//		return mav;
//	}

	@GetMapping("/evaluacion")
	public ModelAndView preguntasErradas(@RequestParam(name="idEvento", required=false)int idEvento,
			@RequestParam(name = "idEvaluacion",required = false) int idEvaluacion) {
		ModelAndView mav = new ModelAndView();
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
		alumnoModel = defineUsuario.buscarUsuarioAlumno(user.getUsername());
		int idAlumno = alumnoModel.getId_alumno();
		AsignaExamenModel asignaExamen = new AsignaExamenModel();
		boolean mostrarRetroalimentacion = false;
		try {
			mostrarRetroalimentacion = validaRealizarExamenAlumno.validaMostrarRetroalimentarcion(idEvaluacion, alumnoModel.getId_alumno(), idEvento);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			LOG.info("ID: "+e.getIdException()+" MENSAJE: "+e.getMsj());
			e.printStackTrace();
		}
		try {
			asignaExamen = validaRealizarExamenAlumno.asignarExamen(idAlumno, idEvento);
			LOG.info("ASIGNA EXAMEN: "+asignaExamen.getIdasignaExamen());
			mav.addObject("examenAsignado", asignaExamen);
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		if(mostrarRetroalimentacion) {
			mav.setViewName(ViewConstant.PREGUNTAS_ERRADAS);
			mav.addObject("listaPreguntas", preguntasErradasConService.listarPregunrasByExam(idEvaluacion, asignaExamen.getIdasignaExamen()));
			mav.addObject("user", alumnoModel );
			return mav;
		}else {
			mav.setViewName(ViewConstant.NO_RETROALIMENTACION);
			mav.addObject("idEvento", idEvento);
			return mav;
		}
		
		
		
	}

}
