package com.sigecu.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AltaAlumnoModel;
import com.sigecu.model.AlumnoHasEventoModel;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.EventosModel;
import com.sigecu.service.InscribirAlumnosService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/inscribirAlumnos")
public class InscribirAlumnosController {
	
	@Autowired
	@Qualifier("inscribirAlumnoService")
	private InscribirAlumnosService inscribirAlumnosService;
	
	private static final Log LOG = LogFactory.getLog(InscribirAlumnosController.class);
	private User user;
	private String username= null;
	
	
	@GetMapping("/altaAlumno")
	public ModelAndView altaAlumnos(Model model) {
		ModelAndView mav = new ModelAndView();
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		AltaAlumnoModel altaAM = new AltaAlumnoModel();
		
		try {
			mav.setViewName(ViewConstant.INSCRIBE_ALUMNO);
			List<AlumnoModel> alumnosModel = inscribirAlumnosService.alumnosAll();
			List<EventosModel> eventosModel = inscribirAlumnosService.eventosAll();
			for(AlumnoModel alumno : alumnosModel) 
				LOG.info("ALUMNOS: "+alumno.toString());
			for(EventosModel evento : eventosModel)
				LOG.info("EVENTOS: "+ evento.toString());
			model.addAttribute("altaAM", altaAM);
			mav.addObject("username", username);
			mav.addObject("alumnos", alumnosModel);
			mav.addObject("eventos", eventosModel);
		} catch (BusinessException e) {
			e.printStackTrace();
			LOG.error(e.getIdException()+" ------"+e.getMsj());
		}
		
		return mav;
	}
	@PostMapping("/guardar")
	public ModelAndView guardaAltaAlumno(@ModelAttribute(name = "altaAM") AltaAlumnoModel altaAM, 
			Model model){
		ModelAndView mav = new ModelAndView();
		LOG.info("ALM: " + altaAM.toString());
		try {
			inscribirAlumnosService.altaAlumnoAEvento(altaAM);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mav.setViewName("redirect:/inscribirAlumnos/altaAlumno");
		
		
		return mav;
	}
}
