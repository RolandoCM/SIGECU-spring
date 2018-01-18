/**
 * 
 */
package com.sigecu.service.implemt;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.sigecu.entity.UserRole;
import com.sigecu.entity.Users;
import com.sigecu.repository.UserRepository;

/**
 * @author Rolando Castillo
 * @contact castillomartinez@acm.org
 * @Fecha 08/01/2018
 *
 */
@Service("userService")
public class UserService implements UserDetailsService{
	private static final Log LOG = LogFactory.getLog(UserService.class);
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		try {
		
			Users user= userRepository.findByUsername(username);
			List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
			
			return buildUser(user, authorities);
		
		}
		catch(UsernameNotFoundException e){
			LOG.error("USUARIO NO ENCONTRADO");
			throw e;
		}
		catch(Exception e){
			e.printStackTrace();
			LOG.error("ERROR EN SERVICE");
			throw e;
		}
	}
	
	
	private User buildUser(Users user, List<GrantedAuthority> authorities) {
		
		return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}
	
	//tranforma roles a listado de GratedAuthority para saber roles de eusuario
	private List<GrantedAuthority> buildAuthorities (Set<UserRole> userRoles){
		
		try {
			
			Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
			for(UserRole userRole : userRoles) {
				auths.add(new SimpleGrantedAuthority(userRole.getRole()));
			
				return new ArrayList<GrantedAuthority>(auths);
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			LOG.error("ERROR EN SERVICE");
			throw e;
			
		}
		
		return null;
	}
}
	
	
