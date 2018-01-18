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
	public ModelAndView showExamenes(@RequestParam(name = "idCurso", required = false) int idCurso, Model model) throws BusinessException{
		EvaluacionesModel evalModel = new EvaluacionesModel();
		ModelAndView mav = new ModelAndView(ViewConstant.LISTAR_EXAMEN);
		try {
		mav.addObject("listaExamen", adminExamService.listAllEvaluaciones(idCurso));
		mav.addObject("username", username);
		List<String> listEval = new ArrayList<>();
		model.addAttribute("evaluacionesModel", evalModel);
		model.addAttribute("listPrueba", listEval);
		model.addAttribute("idCurso", idCurso);
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: ");
			throw be;
		}
		
		return mav;
	}
	
	//@PreAuthorize("hasRole('ROLE_USER')")
	
	@GetMapping("/listaCursos")
	public ModelAndView showCursos() throws BusinessException {
		ModelAndView mav = new ModelAndView(ViewConstant.LISTAR_CURSOS);
		try {
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		username = user.getUsername();
		mav.addObject("username", username);
		//mav.addObject("username", adminExamService.buscarNombre(user.getUsername()));
		mav.addObject("listaCursos", adminExamService.listaCursos());
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Error de conversion");
		}
		return mav;
	}

	@GetMapping("/nuevoExamen")
	public ModelAndView nuevoExamen(@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			Model model) throws BusinessException {
		PreguntasModel preModel = new PreguntasModel();
		RespuestasModel respuestasModel = new RespuestasModel();
		ModelAndView mav = new ModelAndView(ViewConstant.NUEVO_EXAMEN);
		try {
			
		mav.addObject("listaPreguntas", adminExamService.listarPregunrasByExam(idEvaluacion));
		mav.addObject("listaRespuestas", adminExamService.listarRespuestas());
		mav.addObject("username", user.getUsername());
		// agregar respuestas
		model.addAttribute("respuestasModel", respuestasModel);
		model.addAttribute("preModel", preModel);
		model.addAttribute("idEvaluacion", idEvaluacion);
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: No se agregaron respuestas");
			throw be;
		}

		return mav;
	}

	@PostMapping("/addEvaluacion")
	public String addEvaluavion(@ModelAttribute(name = "evaluacionesModel") EvaluacionesModel evalModel,
			@RequestParam(name = "idCurso", required = true) int idCurso, Model model) throws BusinessException {
		try {
		LOG.info("METODO: addEvaluacion --- PARAMETROS " + evalModel.toString() + " idCurso " + idCurso);
		adminExamService.nuevaEvaluacion(evalModel, idCurso);
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: No se encontro el ID");
			throw be;
		}
		return "redirect:/adminExamen/listaExamen?idCurso=" + idCurso;
	}

	@PostMapping("/addPregunta")
	public String addPregunta(@ModelAttribute(name = "preguntasModel") PreguntasModel preguntasModel,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion, Model model)throws BusinessException {
		
		try {
		LOG.info("METODO: ADDPREGUNTA ---- PARAMETROS" + preguntasModel.toString() + " id evaluacione " + idEvaluacion);
		adminExamService.nuevaPregunta(preguntasModel, idEvaluacion);
		}
		catch(Exception e) {
			LOG.error("METODO NO EJECUTADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: ID no encontrado");
			throw be;
		}
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}

	/* Agrega una nueva respuesta a la pregunta X */
	@PostMapping("/addRespuesta")
	public String addRespuesta(@ModelAttribute(name = "respuestaModel") RespuestasModel respuestaModel,
			@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion, Model model)throws BusinessException {
		try {
		LOG.info("PARAMETROS DE " + respuestaModel.toString());
		adminExamService.nuevaRespuesta(respuestaModel, idPregunta);
		}
		catch(Exception e) {
			LOG.error("METODO NO ENCONTRADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Respuesta NO agregada");
			throw be;
			
		}
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
		
	}

	@GetMapping("/removePregunta")
	public String removePregunta(@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion) throws BusinessException{
		try {
		LOG.info("el id de la pregunta es: " + idPregunta);
		adminExamService.eliminaPregunta(idPregunta);
		}
		catch(Exception e) {
			LOG.error("METODO NO ENCONTRADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: ID  no encontrando");
			throw be;
			
		}
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}
	@GetMapping("/removeRespuesta")
	public String removeRespuesta(@RequestParam(name = "idRespuesta", required = true) int idRespuesta,
			@RequestParam(name = "idEvaluacion", required = true) int idEvaluacion) throws BusinessException {
		try {
		LOG.info("el id de la pregunta es: " + idRespuesta);
		adminExamService.eliminarRespuesta(idRespuesta);
		}
		catch(Exception e) {
			LOG.error("METODO NO ENCONTRADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: ID respuesta No encontrado");
			throw be;
		}
		return "redirect:/adminExamen/nuevoExamen?idEvaluacion=" + idEvaluacion;
	}
	@GetMapping("/removeExamen")
	public String removeExamen(@RequestParam(name = "idExamen", required = true) int idExamen,
			@RequestParam(name = "idCurso", required = true) int idCurso) throws BusinessException {
		try {
		LOG.info("el id del curso: "+idCurso+" id de Examen: "+idExamen);
		adminExamService.eliminarExamen(idExamen);
		}
		catch(Exception e) {
			LOG.error("METODO NO ENCONTRADO");
			BusinessException be = new BusinessException();
			be.printStackTrace();
			be.setIdException(001);
			be.setMsj("ERROR EN SERVICE: Id de curso NO encontrado");
			throw be;
		}
		return "redirect:/adminExamen/listaExamen?idCurso="+idCurso;
	}
	

}
