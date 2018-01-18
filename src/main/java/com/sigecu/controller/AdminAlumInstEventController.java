package com.sigecu.controller;

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
import com.sigecu.entity.Users;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.InstructorModel;
import com.sigecu.service.AdminAlumnInstrEveService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/insert")
public class AdminAlumInstEventController {
	
	private static final Log LOG = LogFactory.getLog(AdminAlumInstEventController.class);
	private User user;
	private String username= null;
	
	@Autowired
	@Qualifier("adminAlumnInstrEvServiceImpl")
	private AdminAlumnInstrEveService adminser;
	
	@GetMapping("/alumno")
	public ModelAndView formAlumno(Model model,@RequestParam(name = "InsertadoAlumno", required=false) int InsertadoAlumno) {
		ModelAndView mav = new ModelAndView(ViewConstant.ALUMNO_FORM);
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		AlumnoModel alumn = new AlumnoModel();
		Users usuario = new Users();
		LOG.info("informacion de"+alumn);
		mav.addObject("username", username);
		model.addAttribute("alumnoForm", alumn);
		model.addAttribute("usuarioForm", usuario);
		return mav;
	}
	
	@GetMapping("/instructor")
	public ModelAndView instructorForm(Model model, @RequestParam(name = "idinsetado", required=false)int idinsetado) {
		ModelAndView mav = new ModelAndView(ViewConstant.INSTRUCTOR_FORM);
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		Users usuario = new Users();
		InstructorModel inst = new InstructorModel();
		mav.addObject("username", username);
		model.addAttribute("usuarioForm", usuario);
		model.addAttribute("instructorForm",inst);
		return mav;
	}
	
	@PostMapping("/addAlumno")
	public String addAlumno(@ModelAttribute(name = "alumnoModel") AlumnoModel AlmModel) {
		adminser.nuevoAlumno(AlmModel);
		LOG.info("El Alumno "+AlmModel+"se agrego correctamente");
		
		return "redirect:/insert/alumno?InsertadoAlumno=1";
	}
	
	
	@PostMapping("/addInstructor")
	public String addInstructor(@ModelAttribute(name = "instructorModel") InstructorModel InstruModel) {
		adminser.nuevoInstructor(InstruModel);
		LOG.info("El Instructor se Agrego Correctamente");
		return "redirect:/insert/instructor?idinsetado=1";
	}

}
