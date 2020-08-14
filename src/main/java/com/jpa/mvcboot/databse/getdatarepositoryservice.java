package com.jpa.mvcboot.databse;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.mvcboot.model.user;
import com.jpa.mvcboot.repository.myrepository;
@Service
public class getdatarepositoryservice implements UserDetailsService {
	@Autowired
	myrepository userrepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// user users=userrepository.findByUsername(username);
		user users=userrepository.findByUsername(username);
		 if (users == null) {
	            throw new UsernameNotFoundException(username);
	        }
				return new detailsdatabase(users);
		//return users.map(detailsdatabase::new).get();
	}

}
