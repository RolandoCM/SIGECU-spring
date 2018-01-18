/**
 * 
 */
package com.sigecu.constant;

/**
 * @author zoro
 *
 */
public class ViewConstant {

	/**
	 * 
	 */
	/* login 0 */
	public static final String LOGIN = "publico/login";
	
	//ALUMNO
	public static final String ALUMNO = "redirect:/eventosAlumno/listarEventos"; //vista para alumno inicio
	public static final String INSTRUCTOR = "redirect:/instructor/eventos"; // vista para instructor inicio
	public static final String EVENTOS_INSTRUCTOR = "eventosInstructor";
	public static final String ALUMNOS_EVENTOS_INSTRUCTOR = "listaAlumnosPorEventoInstructor";
	public static final String SEGUIMIENTO_ALUMNO = "segimientoAlumno";
	public static final String EXAMEN_NO_ACTIVO = "examen/examenNoActivo";
	public static final String NUEVO_EXAMENERRADO = "examen/ExamenErrado";
	public static final String NO_RETROALIMENTACION = "examen/warningRetroalimentacion";
	
	public static final String ADMIN = "redirect:/adminExamen/listaCursos"; // vista para admin inicio
	public static final String INSCRIBE_ALUMNO = "inscribirAlumnos";

	public static final String LISTAR_EXAMEN = "adminExamen";
	public static final String NUEVO_EXAMEN = "NuevoExamen";
	public static final String LISTAR_CURSOS = "listaCursosAdmin";

	public static final String MOSTRAR_EXAMEN = "EvaluacionAlumno";
    public static final String CALIFICACIONEXAMEN = "calificaciones";



	public static final String CERTIFICADO = "certificado";
	public static final String EVENTOS_ALUMNO="eventosAlumno";
	

	public static final String PREGUNTAS_ERRADAS ="EvaluacionAlumnoPreguntasErradas";

	public static final String EXAMENES_ALUMNO = "evaluacioneAlumno";

	public static final String CURSOS_ALUMNO = "cursosAlumno";
	
	
	//insertar Alumno
	public static final String ALUMNO_FORM = "alumno";
	
	//instructor
	public static final String INSTRUCTOR_FORM = "instructor";
	//Insertar Eventos
	public static final String EVENTOS_FORM = "EventosInsert";
}
