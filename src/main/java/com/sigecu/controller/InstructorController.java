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
import com.sigecu.model.InstructorModel;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.InstructorService;

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
		return mav;
	}
	@GetMapping("/seguimientoAlumno")
	public ModelAndView seguimientoAlumno(@RequestParam(name="idAlumno", required=true)int idAlumno){
		ModelAndView mav = new ModelAndView(ViewConstant.SEGUIMIENTO_ALUMNO);
		mav.addObject("user", instructorModel );
		return mav;
		
	}
	

}
