package com.example.springmvc.controllers;

import com.example.springmvc.models.Userr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.springmvc.repositories.UserRepository;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

   //  @RequestMapping("/login")
   //  public String login(Model model) {
   //      return "login";
   //  }

   //  @RequestMapping("/login")  
   //  public String login(@RequestParam String user, @RequestParam String password) {
   //    User userNP = new User();
   //    // userNP.getUserId();
   //    // userNP.getPassword();
   //    userNP.setUserId(user);
   //    userNP.setPassword(password);
   //    return "login";
   //  }

   //  public String login(HttpServletRequest request,HttpServletResponse response, Model model) {
	//    String userName=request.getParameter("userName");  
   //    System.out.println(userName);
   //    String password=request.getParameter("password");
   //    if(userName != null && !userName.equals("") && userName.equals("chaitra") && password != null && !password.equals("") && password.equals("123")){
	//       return "/home";
   //    }
   //    else{
   //  	  return "/login";
   //    }
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
       
      //  System.out.println(user.equals(username));
      //  System.out.println(pass.equals(password));
      
       
   }

}



