package com.sigecu.controller;
/**/

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

@Controller
@RequestMapping("/alumno")
public class CertificadoController {
	
	private static final Log LOG = LogFactory.getLog(CertificadoController.class);
	
	@Autowired
    private ApplicationContext applicationContext;
	
	@GetMapping("/inicio")
	public ModelAndView ejemploMAV() {
		ModelAndView mav = new ModelAndView("certificado");
		return mav;
	}
	
	@GetMapping("/certificado")
	public ModelAndView certificado() {
		JasperReportsPdfView cerView = new JasperReportsPdfView();
		cerView.setUrl("classpath:reports/certificado.jrxml");
		cerView.setApplicationContext(applicationContext);
		
		return new ModelAndView(cerView);
	}
}
