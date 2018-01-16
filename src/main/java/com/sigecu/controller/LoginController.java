package com.sigecu.controller;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sigecu.constant.ViewConstant;


@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);
	@GetMapping("/login")
	public String showLoginForm() {
		// LOG.info("METHOD: showLoginForm() -- PARAMS: error= " + error + ", logout= "
		// + logout);
		// model.addAttribute("error", error);
		// model.addAttribute("logout", logout);
		LOG.info("Regresando a la vista login");
		return ViewConstant.LOGIN;
	}

	@GetMapping({"/loginsuccess","/"})
	public String loginCheck() {
		LOG.info("METHOD: logincheck()");
		LOG.info("Regresando a la vista de alumnos");
		
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Iterator<GrantedAuthority> iter= user.getAuthorities().iterator();
		String redirect= ViewConstant.LOGIN;
		while(iter.hasNext()) {
			
			String role = iter.next().getAuthority();
			LOG.info("ROLE: "+role);
			//vista a alumno
			if(role.equals("ROLE_ALUMNO")) {
				redirect = ViewConstant.ALUMNO;
			}
			else if(role.equals("ROLE_INSTRUCTOR")) {
				//vista instructor
				redirect = ViewConstant.INSTRUCTOR;
			}
			else if(role.equals("ROLE_ADMIN")) {
				//vista admin
				redirect= ViewConstant.ADMIN;
			}
			else {
				redirect= ViewConstant.LOGIN;
			}
		}
		LOG.info("ROLE ES: "+ redirect);
		return redirect;
	}
}
