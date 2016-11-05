package com.example.controller;

import com.example.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;

@Controller
public class FormController implements Serializable {

    @RequestMapping("/form")
    public String home(Model model) {

        Person person = new Person();
        model.addAttribute("person", person);

        return "form";
    }

    @RequestMapping(value="/form", method = RequestMethod.POST)
    public void homePost(@ModelAttribute("person") Person person) {
        System.out.println(person);
    }
}
