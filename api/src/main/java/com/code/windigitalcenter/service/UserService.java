package com.code.windigitalcenter.service;

import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.repository.RoleRepository;
import com.code.windigitalcenter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

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

}
