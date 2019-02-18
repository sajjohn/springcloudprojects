package com.myprojects.tutorial.poc.MicroServiceAuthService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myprojects.tutorial.poc.MicroServiceAuthService.repository.UserDetailsRepository;
@Service	
public class UserDetailsServiceImpl implements UserDetailsService{

@Autowired
private UserDetailsRepository userDetailsRepository;
	
@Override
@Transactional(readOnly=true)
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	// TODO Auto-generated method stub
	return userDetailsRepository.findByUsername(username);
}
}
