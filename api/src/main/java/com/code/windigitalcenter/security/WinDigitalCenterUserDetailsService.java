package com.code.windigitalcenter.security;

import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class WinDigitalCenterUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;



    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email);
        if (user != null){
            return new WinDigitalCenterUserDetails(user);
        }
        throw new UsernameNotFoundException("could not found a user with email: "+ email);
    }
}
