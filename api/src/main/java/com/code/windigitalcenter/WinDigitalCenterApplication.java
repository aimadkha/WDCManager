package com.code.windigitalcenter;

import com.code.windigitalcenter.entity.Role;
import com.code.windigitalcenter.entity.User;
import com.code.windigitalcenter.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class WinDigitalCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(WinDigitalCenterApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "USER"));
            userService.saveRole(new Role(null, "MANAGER"));
            Role role = userService.saveRole(new Role(null, "ADMIN"));
            userService.saveRole(new Role(null, "SUPER_ADMIN"));
            Integer roleId= 6;


            userService.save(new User(null, "aimadd", "aimadd", "male", "765765765765", "aimadd@test.com", "aimadaimad",true, role));

            userService.saveUser(new User(null, "yassin EL", "yassin", "aimad@test.com", "aimadaimad", new ArrayList<>()));
            userService.saveUser(new User(null, "hajar EL", "hajar", "aimad@test.com", "aimadaimad", new ArrayList<>()));
            userService.saveUser(new User(null, "ziad EL", "ziad", "aimad@test.com", "aimadaimad", new ArrayList<>()));




            userService.addRoleToUser("aimad", "Role_SUPER_ADMIN");
            userService.addRoleToUser("ziad", "Role_ADMIN");
            userService.addRoleToUser("hajar", "Role_USER");
            userService.addRoleToUser("yassin", "Role_ADMIN");


        };


    }

 */


}
