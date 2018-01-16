package com.sigecu.controller;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.model.AlumnoModel;
import com.sigecu.service.CalificacionService;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.EvaluacionAlumnoService;
import com.sigecu.service.implemt.EmailService;

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/calificaciones")
public class CalificacionesController {
	@Autowired
	@Qualifier("EvaluacionAlumnoImpl")
	private EvaluacionAlumnoService EvaluacionAlumnoService;
	
	
	@Autowired
	@Qualifier("CalificacionImplement")
	private CalificacionService calificacionService;
	
	@Autowired
	@Qualifier("emailService")
	private EmailService mailService;
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;
	
	private static final Log LOG = LogFactory.getLog(CalificacionesController.class);
	private User user;
	AlumnoModel alumnoModel;
	
	@GetMapping("/mostrarCalificaciones")
	public ModelAndView mostrarExamen(@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			@RequestParam(name = "idAsignaExamen", required = false) int idAsignaExamen){
		ModelAndView mav = new ModelAndView(ViewConstant.CALIFICACIONEXAMEN );
		
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
		
		//mav.addObject("ePorsentaje",EvaluacionAlumnoService.calificacion(1));
		mav.addObject("resumen",calificacionService.calificacionFnl(idEvaluacion,idAsignaExamen));
		mav.addObject("user", alumnoModel );
		try {
			mailService.send(alumnoModel.getA_email(), "Examen realizado", "Calificacion Final: "+"");
		} catch (AddressException e) {
			LOG.error("La direccion de correo es incorrecta");
			e.printStackTrace();
		} catch (MessagingException e) {
			LOG.info("Error en el envio del correo");
			e.printStackTrace();
		}
		return mav;
	}
	
}
