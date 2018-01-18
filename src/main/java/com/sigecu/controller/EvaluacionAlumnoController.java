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
import com.sigecu.service.ValidarExamenAlumnoService;

@Controller
@PreAuthorize("hasRole('ROLE_ALUMNO')")
@RequestMapping("/EvaluacionAlumno")
public class EvaluacionAlumnoController {

	private static final Log LOG = LogFactory.getLog(EvaluacionAlumnoController.class);
	private User user;
	AlumnoModel alumnoModel;

	@Autowired
	@Qualifier("EvaluacionAlumnoImpl")
	private EvaluacionAlumnoService evaluacionAlumnoService;

	@Autowired
	@Qualifier("validarRealizarExamen")
	private ValidarExamenAlumnoService validaRealizarExamenAlumno;
	@Autowired
	@Qualifier("defineUsuario")
	private DefineUsuarioService defineUsuario;

	@GetMapping("/mostrarExamen")
	public ModelAndView mostrarExamenN(@RequestParam(name = "idEvento", required = false) int idEvento,
			@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion, Model model) {
		VistaRespuestasAlumno respuestaAlumno = new VistaRespuestasAlumno();

		ModelAndView mav = new ModelAndView();
		boolean validaActivo = false;
		user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		alumnoModel = defineUsuario.buscarUsuarioAlumno(user.getUsername());
		int idAlumno = alumnoModel.getId_alumno();
		AsignaExamenModel asignaExamen = new AsignaExamenModel();

		try {
			validaActivo = validaRealizarExamenAlumno.validaRealizarExamen(idEvaluacion, idAlumno, idEvento);
		} catch (BusinessException e) {
			LOG.info("ID: " + e.getIdException() + " MENSAJE: " + e.getMsj());
			e.printStackTrace();
		}

		if (validaActivo) {
			mav.setViewName(ViewConstant.MOSTRAR_EXAMEN);
			mav.addObject("user", alumnoModel);
			try {
				asignaExamen = validaRealizarExamenAlumno.asignarExamen(idAlumno, idEvento);
				LOG.info("ASIGNA EXAMEN: "+asignaExamen.getIdasignaExamen());
				mav.addObject("examenAsignado", asignaExamen);
			} catch (BusinessException e) {
				e.printStackTrace();
			}

			List<PreguntasModel> listaPreguntas = evaluacionAlumnoService.listarPreguntasByEvaluacion(idEvaluacion,
					asignaExamen.getIdasignaExamen());
			if (listaPreguntas.size() > 0) {
				mav.addObject("listaPreguntas", listaPreguntas);
				mav.addObject("idEvaluacion", idEvaluacion);
				mav.addObject("idEvento", idEvento);

				model.addAttribute("respuestaAlumno", respuestaAlumno);
				model.addAttribute("eTiempo", evaluacionAlumnoService.tiempoExamen(idEvaluacion));
				model.addAttribute("eHoraInicio",evaluacionAlumnoService.horaInicio(idEvaluacion));
				model.addAttribute("eHoraFin",evaluacionAlumnoService.horaFin(idEvaluacion));
			} else {
				LOG.info("EXAMEN TERMINADO..........");
				mav.setViewName("redirect:/calificaciones/mostrarCalificaciones?idEvaluacion="+idEvaluacion+"&idAsignaExamen="+asignaExamen.getIdasignaExamen());
				evaluacionAlumnoService.marcarExamenRealizado(asignaExamen.getIdasignaExamen());
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
		LOG.info("EXAMEN GUARDADO: " + respuestaAlumno.toString() + " ASIGNA EXAMEN =");
		evaluacionAlumnoService.guardarRespuestas(respuestaAlumno.getIdRespuesta(), idAsignaExamen, idPregunta);
		
		// " + idAsignaExamen);

		return "redirect:/EvaluacionAlumno/mostrarExamen?idEvento=" + idEvento + "&idEvaluacion=" + idEvaluacion;
	}

	@GetMapping("/finaliza")
	public String finaliza(@RequestParam(name = "idEvento", required = false) int idEvento,
			@RequestParam(name = "idEvaluacion", required = false) int idEvaluacion,
			@RequestParam(name = "asignaExamen", required = true) int idAsignaExamen,
			@RequestParam(name = "idPregunta", required = true) int idPregunta,
			@ModelAttribute(name = "respuestaAlumno") VistaRespuestasAlumno respuestaAlumno) {
		LOG.info("EXAMEN GUARDADO: " + respuestaAlumno.toString() + " ASIGNA EXAMEN ="+ idAsignaExamen);
		evaluacionAlumnoService.guardarRespuestas(respuestaAlumno.getIdRespuesta(), idAsignaExamen, idPregunta);
		evaluacionAlumnoService.marcarExamenRealizado(idAsignaExamen);
		

		return "redirect:/calificaciones/mostrarCalificaciones?idEvaluacion="+idEvaluacion+"i&dAsignaExamen="+idAsignaExamen;
	}
}
