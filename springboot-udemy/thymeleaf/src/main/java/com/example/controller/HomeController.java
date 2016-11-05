package com.example.controller;

import com.example.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;

@Controller
public class HomeController implements Serializable {

    @RequestMapping("/home")
    public ModelAndView home(ModelAndView modelAndView) {

        Person person = new Person();
        person.setFirstName("Dustin");
        person.setEmail("egodestruct@gmail.com");

        modelAndView.addObject("person", person);
        modelAndView.setViewName("home");

        return modelAndView;
    }
}
