package com.sigecu.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.model.AlumnoModel;
import com.sigecu.service.CertificadoService;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.implemt.AlumnoHasEventoServiceImpl;

import com.sigecu.service.implemt.CertificadoServiceImpl;
import com.sigecu.service.implemt.EventoAlumnoImpl;


@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/alumno")
public class CertificadoController {
	
	private static final Log LOG = LogFactory.getLog(CertificadoController.class);
	private User user;
	AlumnoModel alumnoModel;
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@Autowired
	private CertificadoServiceImpl certificadoService;
	
	@Autowired
	private AlumnoHasEventoServiceImpl alumnoHasEventoService;
	
	@Autowired
	@Qualifier("eventoAlumnoImpl")
	private EventoAlumnoImpl eventoAlumnoImpl;  
	
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;


	
	@GetMapping("/certificado")
		public ModelAndView certificado2(
			@RequestParam(name = "idEvento", required = false) int idEvento) {
		
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
		
		int validar = eventoAlumnoImpl.validarcertificado(alumnoModel.getId_alumno(), idEvento);
		
		if (validar==1) {
			JasperReportsPdfView cerView = new JasperReportsPdfView();
			cerView.setUrl("classpath:reports/certificadoR.jrxml");
			cerView.setApplicationContext(applicationContext);
			Map<String, Object> params = new HashMap<String, Object>();
		    params.put("datasource", alumnoHasEventoService.report(alumnoModel.getId_alumno(), idEvento));
		    //params.put("img", this.getClass().getResource("/src/main/resources/reports/c.png"));
			return new ModelAndView(cerView, params);
		}else {
			return new ModelAndView(ViewConstant.ERROR_404);
		}
		
	}
	
	
}
