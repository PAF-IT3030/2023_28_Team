package com.paf.favorfeed.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.paf.favorfeed.repository.UserRepository;

@Service
public class UserUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.paf.favorfeed.model.User> opt = userRepository.findByEmail(username); 
		
		if(opt.isPresent()) {
			com.paf.favorfeed.model.User user=opt.get();
			
			List<GrantedAuthority> authorities=new ArrayList<>();
			
			return new User(user.getEmail(), user.getPassword(), authorities);
		}
		
		throw new BadCredentialsException("User not found with username"+username);
	}

}
