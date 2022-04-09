/*
package com.code.windigitalcenter.security;

import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.service.UserService;
import com.code.windigitalcenter.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("could not found user with name :"+username);
        }
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getIdRole().getNomRole()));

        return WinDigitalCenterUserDetailsService.builder()
                .user(user).id(user.getId())
                .username(username)
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }


}

 */
