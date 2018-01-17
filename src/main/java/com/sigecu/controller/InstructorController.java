/**
 * 
 */
package com.sigecu.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.InstructorModel;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.InstructorService;
import com.sigecu.service.SeguimientoAlumnoService;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Controller
@PreAuthorize("hasRole('ROLE_INSTRUCTOR')")
@RequestMapping("/instructor")
public class InstructorController {
	private static final Log LOG = LogFactory.getLog(InstructorController.class);
	
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;
	
	@Autowired
	@Qualifier("instructorServiceImpl")
	private InstructorService instructorService;
	
	@Autowired
	@Qualifier("seguimientoAlumnoService")
	private SeguimientoAlumnoService seguimientoAlumnoService;
	
	private User user;
	private InstructorModel instructorModel;
	
	@GetMapping("/eventos")
	public ModelAndView mostrarEventos() {
		ModelAndView mav = new ModelAndView(ViewConstant.EVENTOS_INSTRUCTOR);
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		instructorModel =defineUsuario.buscarUsuarioInstructor(user.getUsername());
		mav.addObject("user", instructorModel );
		mav.addObject("listarEventos", instructorService.eventosPorInstructor(instructorModel.getId()));
		return mav;
	}
	@GetMapping("/alumnosEvento")
	public ModelAndView mostrarAlumnosPorEvento(@RequestParam(name="idEvento", required=true) int idEvento) {
		ModelAndView mav = new ModelAndView(ViewConstant.ALUMNOS_EVENTOS_INSTRUCTOR);
		LOG.info("MOSTRAR ALUMNOS POR EVENTO");
		mav.addObject("user", instructorModel );
		mav.addObject("listaAlumnos", instructorService.alumnosPorEvento(idEvento));
		mav.addObject("idEvento", idEvento);
		return mav;
	}
	/*
	 * Seguimiento de los alumnos 
	 * mostrar datos del alumno referente al curso: calificacion, activar examen,etc 
	 * */
	@GetMapping("/seguimientoAlumno")
	public ModelAndView seguimientoAlumno(@RequestParam(name="idAlumno", required=true) int idAlumno, 
			@RequestParam(name="idEvento", required=true) int idEvento,
			Model model){
		ModelAndView mav = new ModelAndView(ViewConstant.SEGUIMIENTO_ALUMNO);
		AlumnoModel alumnoModel;
		AsignaExamenModel registroAsigna = new AsignaExamenModel();
		List<Object> datos = new ArrayList<>();
		try {
			alumnoModel = seguimientoAlumnoService.findAlumno(idAlumno);
			mav.addObject("alumno", alumnoModel);
			datos = seguimientoAlumnoService.datosAlumno(alumnoModel, idEvento);
			mav.addObject("evaluacion", datos.get(0));
			mav.addObject("resultadoExamen", datos.get(1));
			mav.addObject("asignaExamen", datos.get(2)); 
			mav.addObject("idEvento", idEvento);
			model.addAttribute("registroAsigna", registroAsigna);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mav.addObject("user", instructorModel );
		return mav;
	}
	@PostMapping("/asignarExamen")
	public ModelAndView asignaExamen(@ModelAttribute(name = "registroAsigna") AsignaExamenModel asignaExamen,
			@RequestParam(name="idAlumno", required=true) int idAlumno, 
			@RequestParam(name="idEvento", required=true) int idEvento,
			@RequestParam(name="idEvento", required=true) int idAsignaExamen) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/instructor/seguimientoAlumno?idAlumno="+idAlumno+"&idEvento="+idEvento);
		LOG.info("ASIGNADO: " + asignaExamen.toString()+ "idAsigna: "+idAsignaExamen);
		try {
			seguimientoAlumnoService.activarExamenAlumno(idAsignaExamen, asignaExamen);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return mav;
	}
	

}
