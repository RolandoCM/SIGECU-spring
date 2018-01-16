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
import com.sigecu.model.EvaluacionesModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.RespuestasModel;
import com.sigecu.service.AdminExamService;

//import com.escuela.constant.ViewConstant;
///import com.sigecu.service.CursoService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/adminExamen")
public class AdminExamController {

	private static final Log LOG = LogFactory.getLog(AdminExamController.class);
	private User user;
	private String username= null;
	@Autowired
	@Qualifier("adminExamServiceImpl")
	private AdminExamService adminExamService;
	@GetMapping("/listaExamen")
	public ModelAndView showExamenes(@RequestParam(name = "idCurso", required = false) int idCurso, Model model) {
		EvaluacionesModel evalModel = new EvaluacionesModel();
		
		ModelAndView mav = new ModelAndView(ViewConstant.LISTAR_EXAMEN);
		mav.addObject("listaExamen", adminExamService.listAllEvaluaciones(idCurso));
		mav.addObject("username", username);
		List<String> listEval = new ArrayList<>();
		model.addAttribute("evaluacionesModel", evalModel);
		model.addAttribute("listPrueba", listEval);
		model.addAttribute("idCurso", idCurso);
		return mav;
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	
	@GetMapping("/listaCursos")
	public ModelAndView showCursos() {
		ModelAndView mav = new ModelAndView(ViewConstant.LISTAR_CURSOS);
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		mav.addObject("username", username);
		//mav.addObject("username", adminExamService.buscarNombre(user.getUsername()));
		mav.addObject("listaCursos", adminExamService.listaCursos());
		return mav;
	}

	@GetMapping("/nuevoExamen")
	public ModelAndView nuevoExamen(@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			Model model) {
		PreguntasModel preModel = new PreguntasModel();
		RespuestasModel respuestasModel = new RespuestasModel();
		ModelAndView mav = new ModelAndView(ViewConstant.NUEVO_EXAMEN);
		mav.addObject("listaPreguntas", adminExamService.listarPregunrasByExam(idEvaluacion));
		mav.addObject("listaRespuestas", adminExamService.listarRespuestas());
		mav.addObject("username", user.getUsername());
		// agregar respuestas
		model.addAttribute("respuestasModel", respuestasModel);
		model.addAttribute("preModel", preModel);
		model.addAttribute("idEvaluacion", idEvaluacion);

		return mav;
	}

	@PostMapping("/addEvaluacion")
	public String addEvaluavion(@ModelAttribute(name = "evaluacionesModel") EvaluacionesModel evalModel,
			@RequestParam(name = "idCurso", required = true) int idCurso, Model model) {
		LOG.info("METODO: addEvaluacion --- PARAMETROS " + evalModel.toString() + " idCurso " + idCurso);
		adminExamService.nuevaEvaluacion(evalModel, idCurso);
		return "redirect:/adminExamen/listaExamen?idCurso=" + idCurso;
	}

	@PostMapping("/addPregunta")
	public String addPregunta(@ModelAttribute(name = "preguntasModel") PreguntasModel preguntasModel,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion, Model model) {
		LOG.info("METODO: ADDPREGUNTA ---- PARAMETROS" + preguntasModel.toString() + " id evaluacione " + idEvaluacion);
		adminExamService.nuevaPregunta(preguntasModel, idEvaluacion);
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}

	/* Agrega una nueva respuesta a la pregunta X */
	@PostMapping("/addRespuesta")
	public String addRespuesta(@ModelAttribute(name = "respuestaModel") RespuestasModel respuestaModel,
			@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion, Model model) {
		LOG.info("PARAMETROS DE " + respuestaModel.toString());
		adminExamService.nuevaRespuesta(respuestaModel, idPregunta);
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}

	@GetMapping("/removePregunta")
	public String removePregunta(@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion) {
		LOG.info("el id de la pregunta es: " + idPregunta);
		adminExamService.eliminaPregunta(idPregunta);
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}
	@GetMapping("/removeRespuesta")
	public String removeRespuesta(@RequestParam(name = "idRespuesta", required = true) int idRespuesta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion) {
		LOG.info("el id de la pregunta es: " + idRespuesta);
		adminExamService.eliminarRespuesta(idRespuesta);
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}
	@GetMapping("/removeExamen")
	public String removeExamen(@RequestParam(name = "idExamen", required = true) int idExamen,
			@RequestParam(name = "idCurso", required = true) int idCurso) {
		LOG.info("el id del curso: "+idCurso+" id de Examen: "+idExamen);
		adminExamService.eliminarExamen(idExamen);
		return "redirect:/adminExamen/listaExamen?idCurso="+idCurso;
	}
	

}
