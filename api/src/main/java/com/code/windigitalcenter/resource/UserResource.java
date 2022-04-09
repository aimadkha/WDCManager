package com.code.windigitalcenter.resource;


import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping("/userstest")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.save(user));
    }

    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.save(role));
    }

    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoletoUser(@RequestBody Role role){
        return ResponseEntity.ok().body(userService.save(role));
    }







}
