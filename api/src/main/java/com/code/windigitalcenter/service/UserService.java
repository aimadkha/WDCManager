package com.code.windigitalcenter.service;

import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.repository.RoleRepository;
import com.code.windigitalcenter.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional @Slf4j
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public List<User> getAllUsers(){
        log.info("get list of users");
        return (List<User>) userRepository.findAll();
    }

    public User getUserByEmail(String email){
        log.info("get user by emmail");
        return userRepository.findUserByEmail(email);

    }

    public User findByUsername(String username){
        return userRepository.findUserByNomUser(username);
    }

    public void deleteUser(Integer id){
        log.info("deleted user with id "+id);
        Long countById = userRepository.countById(id);
        if (countById == null || countById == 0){
            throw new UsernameNotFoundException("could not found a user with id : "+ id);
        }
        userRepository.deleteById(id);

    }

    public User save(User user) {
        log.info("saving new user to the database");
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

    public Role save(Role role){
        return roleRepository.save(role);
    }

    public Role findRole(Integer id){
        log.info("find role");
        return roleRepository.findById(id).get();
    }

}
