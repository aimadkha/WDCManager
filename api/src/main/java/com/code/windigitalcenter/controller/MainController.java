package com.code.windigitalcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("")
    public String viewHomePage(){
        return "test main controller";
    }
}
