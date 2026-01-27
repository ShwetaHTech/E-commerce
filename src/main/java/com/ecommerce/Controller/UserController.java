//package com.ecommerce.Controller;
//
//import com.ecommerce.Entity.User;
//import com.ecommerce.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    public String registerUser(@ModelAttribute User user){
//        userRepository.save(user);
//        return "login";
//    }
//}
//
//
//


//package com.ecommerce.controller;

//import com.ecommerce.Entity.User;
//import com.ecommerce.Repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    private UserRepository userRepository;
//    @PostMapping("/register")
//    public String register(@ModelAttribute User user){
//        userRepository.save(user);
//        return "login";
//    }
//}


package com.ecommerce.Controller;

import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(@ModelAttribute User user){
        userRepository.save(user);
        return "login";
    }
}






