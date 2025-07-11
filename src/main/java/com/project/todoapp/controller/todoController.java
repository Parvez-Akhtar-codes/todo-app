package com.project.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class todoController {

    @GetMapping({"","/","/home"})
    public String showHomePage(){
        return "index";
    }
}
