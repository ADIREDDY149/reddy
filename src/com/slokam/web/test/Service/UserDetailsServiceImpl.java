package com.slokam.web.test.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.slokam.web.test.Dao.UserDao;
import com.slokam.web.test.pojo.GranntedAuthorityImpl;
import com.slokam.web.test.pojo.UserDetailsImpl;

public class UserDetailsServiceImpl implements UserDetailsService{
//filter going to call this loaduserbyname
	
	private UserDao userdao;
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}

	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// logic we have to write
		return userdao.getUserDetailsByName(arg0);
		
		/*UserDetailsImpl userDetails=new UserDetailsImpl();
		userDetails.setAccountNonExpired(true);
		userDetails.setCredentialsNonExpired(true);
		userDetails.setAccountNonLocked(true);

		userDetails.setEnabled(true);
		userDetails.setUsername(arg0);
		userDetails.setPassword("abc");
		
		Collection<GranntedAuthorityImpl> autority=new ArrayList<GranntedAuthorityImpl>();
		
		GranntedAuthorityImpl autorities=new GranntedAuthorityImpl();
		autorities.setAuthority("ROLE_USER");
		
		GranntedAuthorityImpl autorities1=new GranntedAuthorityImpl();
		
		autorities1.setAuthority("ROLE_SALE");
		
		GranntedAuthorityImpl autorities2=new GranntedAuthorityImpl();
		
		autorities2.setAuthority("ROLE_Manager");
		
		autority.add(autorities);
		autority.add(autorities1);
		autority.add(autorities2);
		
		userDetails.setAuthorities(autority);
		
		return userDetails;*/
	}

}
