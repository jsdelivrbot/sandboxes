package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        //Spring boot + thymeleaf will automatically consider this "home" string as a template reference, and load
        //the appropriate html file under templates (in this case, home.html)
        return "home";
    }

}
