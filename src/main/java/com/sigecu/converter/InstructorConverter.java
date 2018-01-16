/**
 * 
 */
package com.sigecu.converter;

import org.springframework.stereotype.Component;

import com.sigecu.entity.Instructor;
import com.sigecu.model.InstructorModel;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 09/01/2018
 *
 */
@Component("instructorConverter")
public class InstructorConverter {

	//entity to model
	public InstructorModel converterEntityToModel(Instructor instructor) {

		InstructorModel instructorModel = new InstructorModel();
		instructorModel.setId(instructor.getIdInstructor());
		instructorModel.setiNombre(instructor.getiNombre());
		instructorModel.setiPaterno(instructor.getiPaterno());
		instructorModel.setiMaterno(instructor.getiMaterno());
		instructorModel.setCarrera(instructor.getCarrera());
		instructorModel.setiDireccion(instructor.getiDireccion());
		instructorModel.setiEmail(instructor.getiDireccion());
		instructorModel.setiTelefono(instructor.getiTelefono());
		
		return instructorModel;
	}
	
	
	//model to entity
}
