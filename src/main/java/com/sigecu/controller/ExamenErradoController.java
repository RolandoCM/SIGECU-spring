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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sigecu.constant.ViewConstant;
import com.sigecu.exception.BusinessException;
import com.sigecu.model.AlumnoModel;
import com.sigecu.model.AsignaExamenModel;
import com.sigecu.model.PreguntasModel;
import com.sigecu.model.VistaRespuestasAlumno;
import com.sigecu.service.DefineUsuarioService;
import com.sigecu.service.EvaluacionAlumnoService;
import com.sigecu.service.ExamenErradoService;
import com.sigecu.service.ValidarExamenAlumnoService;

/**
 * @author Anel
 *
 */


@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/ExamenErrado")
public class ExamenErradoController {
	
	private static final Log LOG = LogFactory.getLog(ExamenErradoController.class);
	private User user;
	AlumnoModel alumnoModel;

	@Autowired
	@Qualifier("ExamenErradoServiceImplement")
	private ExamenErradoService examenErradoService;
	
	@Autowired
	@Qualifier("EvaluacionAlumnoImpl")
	private EvaluacionAlumnoService EvaluacionAlumnoService;
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;

	@Autowired
	@Qualifier("EvaluacionAlumnoImpl")
	private EvaluacionAlumnoService evaluacionAlumnoService;

	@Autowired
	@Qualifier("validarRealizarExamen")
	private ValidarExamenAlumnoService validaRealizarExamenAlumno;

	@GetMapping("/ExamenErrado1")
	public ModelAndView ExamenErrado1(@RequestParam(name="idEvento", required=true)int idEvento,
			@RequestParam(name="idEvaluacion", required=true)int idEvaluacion, 
			Model model) {
		
		boolean validaReactivado= false; 
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		alumnoModel =defineUsuario.buscarUsuarioAlumno(user.getUsername());
		int idAlumno = alumnoModel.getId_alumno();
		AsignaExamenModel asignaExamen = new AsignaExamenModel();
		VistaRespuestasAlumno respuestaAlumno = new VistaRespuestasAlumno();
		ModelAndView mav = new ModelAndView();
		try {
			validaReactivado = validaRealizarExamenAlumno.validaSegundaOportunidadExamen(idEvaluacion, alumnoModel.getId_alumno(), idEvento);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			LOG.info("ID: "+e.getIdException()+" MENSAJE: "+e.getMsj());
			e.printStackTrace();
		} 
		
		if (validaReactivado) {
			mav.setViewName(ViewConstant.NUEVO_EXAMENERRADO);
			mav.addObject("user", alumnoModel);
			try {
				asignaExamen = validaRealizarExamenAlumno.asignarExamen(idAlumno, idEvento);
				mav.addObject("examenAsignado", asignaExamen);
			} catch (BusinessException e) {
				e.printStackTrace();
				e.getMsj();
			}

			List<PreguntasModel> listaPreguntas = examenErradoService.listarPreguntasByExamErrado(idEvaluacion, asignaExamen.getIdasignaExamen());
			if (listaPreguntas.size() > 0) {
				LOG.info(listaPreguntas.size());
				mav.addObject("listaPreguntas", listaPreguntas);
				mav.addObject("idEvaluacion", idEvaluacion);
				mav.addObject("idEvento", idEvento);
				
				model.addAttribute("respuestaAlumno", respuestaAlumno);
				LOG.info("BIEN ...................");
				//model.addAttribute("eTiempo", evaluacionAlumnoService.tiempoExamen(idEvaluacion));
				//model.addAttribute("eHoraInicio",evaluacionAlumnoService.horaInicio(idEvaluacion));
				//model.addAttribute("eHoraFin",evaluacionAlumnoService.horaFin(idEvaluacion));
			} else {
				evaluacionAlumnoService.marcarExamenRealizado(asignaExamen.getIdasignaExamen());
				mav.setViewName("redirect:/calificaciones/mostrarCalificaciones?idEvaluacion="+idEvaluacion+"&idAsignaExamen="+asignaExamen.getIdasignaExamen());
			}

			return mav;
		} else {
			mav.setViewName(ViewConstant.EXAMEN_NO_ACTIVO);
			mav.addObject("idEvento", idEvento);
			return mav;
		}
	}

	@PostMapping("/guardaRespuesta")
	public String guardaRespuesta(@RequestParam(name = "idEvento", required = false) int idEvento,
			@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			@RequestParam(name = "asignaExamen", required = true) int idAsignaExamen,
			@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@ModelAttribute(name = "respuestaAlumno") VistaRespuestasAlumno respuestaAlumno) {

		 examenErradoService.guardarRespuestas(respuestaAlumno.getIdRespuesta(), idAsignaExamen, idPregunta);
		 LOG.info("EXAMEN GUARDADO: " + respuestaAlumno.toString() + " ASIGNA EXAMEN =" + idAsignaExamen);
		return "redirect:/ExamenErrado/ExamenErrado1?idEvento=" + idEvento + "&idEvaluacion=" + idEvaluacion;
	}

	@GetMapping("/finaliza")
	public String finaliza(@RequestParam(name = "idEvento", required = false) int idEvento,
			@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			@RequestParam(name = "asignaExamen", required = true) int idAsignaExamen,
			@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@ModelAttribute(name = "respuestaAlumno") VistaRespuestasAlumno respuestaAlumno) {

		//evaluacionAlumnoService.guardarRespuestas(respuestaAlumno.getIdRespuesta(), idAsignaExamen);
		examenErradoService.guardarRespuestas(respuestaAlumno.getIdRespuesta(), idAsignaExamen, idPregunta);
		LOG.info("EXAMEN GUARDADO: " + respuestaAlumno.toString() + " ASIGNA EXAMEN ="+ idAsignaExamen);

		return "redirect:/calificaciones/mostrarCalificaciones?idEvaluacion="+idEvaluacion+"i&dAsignaExamen="+idAsignaExamen;
	}
	


}
