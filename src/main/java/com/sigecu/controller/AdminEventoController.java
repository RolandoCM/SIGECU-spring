package com.sigecu.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import com.sigecu.constant.ViewConstant;
import com.sigecu.model.RegistrarEventoModel;
import com.sigecu.service.AdminEventoService;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/adminEvento")
public class AdminEventoController {
	private static final Log LOG = LogFactory.getLog(AdminEventoController.class);
	
	private User user;
	private String username=null;
	
	 @Autowired
	 @Qualifier("adminEventoServiceImpl")
	 private AdminEventoService adminEventoService;
	 
	 @GetMapping("nuevoEvento")
	 public ModelAndView insetarDatos(@RequestParam(name="idEvento", required=false) int idEvento,
			 Model model) {		
		RegistrarEventoModel registraEventoModel=new RegistrarEventoModel();
		ModelAndView mav=new ModelAndView(ViewConstant.NUEVO_EVENTO);
		mav.addObject("listaCursos", adminEventoService.listaCursos());
		mav.addObject("listaInstructor",adminEventoService.listaInstructor());
		mav.addObject("username", username);
		model.addAttribute("registraEventoModel", registraEventoModel);
		model.addAttribute("idEvento", idEvento);
		 
		return mav;
	 }
	
	 
}
