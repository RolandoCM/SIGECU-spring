/**
 * 
 */
package com.sigecu.constant;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
public class TestEncry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
		System.out.println(pe.encode("user"));

	}

}
