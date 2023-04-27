package com.example.springmvc.controllers;
import com.example.springmvc.models.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repositories.UserRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

   @RequestMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @RequestMapping("/l")
    public String l(Model model) {
        return "login";
    }

   @RequestMapping("/log")
   public String log(@RequestParam String userId, @RequestParam String password) {
       Userr details = userRepository.findById(userId).orElse(null);
       if(details!=null){
         String user = details.getUserId();
         String pass = details.getPassword();
         if((user.equals(userId)) && (pass.equals(password))) return "home";
         else return "login";
       }
       else return "login";
   }

}



