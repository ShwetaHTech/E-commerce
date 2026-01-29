package com.ecommerce.Controller;

import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    // Injecting UserRepository to interact with database
    @Autowired
    private UserRepository userRepository;

    // This method is called when REGISTER form is submitted
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {

        // Saving user object into database
        userRepository.save(user);

        // After successful registration, redirect to login page
        return "login";
    }
}


