package com.code.windigitalcenter.service;

import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.repository.RoleRepository;
import com.code.windigitalcenter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor

@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    //private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String nomUser) throws UsernameNotFoundException {
        User user = userRepository.findByNomUser(nomUser);
        if (user == null) {
            System.out.println("if");
            log.error("User not found in the database{}", nomUser);
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            //System.out.println("else "+ user.getEmail()+" "+user);
            log.info("User found in the database {} ", user.getNomUser());

        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
      //  user.getIdRole().getNomRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(user.getIdRole().getNomRole()));
       // });
        log.info("after elsee : "+ user.getNomUser());
        log.info(authorities.toString());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                authorities);
    }

    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    public void deleteUser(Integer id){
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0){
            throw new UsernameNotFoundException("could not found a user with id : "+ id);
        }
        userRepository.deleteById(id);

    }

    public User save(User user) {
        boolean isUpdatingUser = (user.getId() != null);

        if (isUpdatingUser) {
            User exisctingUser = userRepository.findById(user.getId()).get();
            if (user.getPassword().isEmpty()) {
                user.setPassword(exisctingUser.getPassword());
            } else {
                encodePassword(user);
            }
        } else {
            encodePassword(user);
        }

        return userRepository.save(user);
    }

    public void encodePassword(User user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }

    public Role role(Integer id){
        return roleRepository.findById(id).get();
    }


    public void addRoleToUser(String email, String roleName) {
        log.info("saving role to username");
        User user = userRepository.findUserByEmail(email);
        Role role = roleRepository.findRoleByNomRole(roleName);
        user.getIdRole().getNomRole();

    }



    public Role saveRole(Role role){
        return roleRepository.save(role);
    }



}
