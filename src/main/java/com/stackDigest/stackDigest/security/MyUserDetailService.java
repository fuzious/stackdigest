package com.stackDigest.stackDigest.security;

import com.stackDigest.stackDigest.beans.database.UserD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String  username) throws UsernameNotFoundException {
		UserD userD=userRepository.findById(Integer.parseInt(username));
		if (userD==null)
			throw new  UsernameNotFoundException("User 404");
		return new MyUserDetails(userD);
	}


}
