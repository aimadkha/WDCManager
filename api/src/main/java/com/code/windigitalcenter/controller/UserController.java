package com.code.windigitalcenter.controller;

import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.repository.UserRepository;
import com.code.windigitalcenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> viewUsersList(){
        List<User> users =  userService.getAllUsers();
        System.out.println("test");
        return users;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id){
        System.out.println("test delete");
        userService.deleteUser(id);
    }

    @PostMapping("/users")
    User newUser(@RequestBody User user){
        System.out.println("test");
      // System.out.println(user.getNomUser());
      // Role roleAdmin = userService.role(1);
     //  user.setIdRole(roleAdmin);
     //  User user = new User("aimad", "elkha","male", "98798798", "lkql@test.com", "aimadaimad", false, roleAdmin);

       // user.setId(0);
        userService.save(user);

        return user;
    }

}
