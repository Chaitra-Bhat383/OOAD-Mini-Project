package com.example.springmvc.controllers;

import com.example.springmvc.models.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.springmvc.repositories.UserRepository;


@Controller
public class RegistrationController {
    
    @Autowired
    UserRepository userRepository;

    @RequestMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @RequestMapping("/r")
    public String r(Model model) {
        return "register";
    }

    @RequestMapping("/userpass")
    public String userpass(@RequestParam String userId, @RequestParam String password) {
        Userr userNP = new Userr();
        userNP.setUserId(userId);
        userNP.setPassword(password);
        userRepository.save(userNP);
        return "redirect:/login";
      }

}