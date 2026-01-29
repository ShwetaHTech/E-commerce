package com.ecommerce.Controller;

import com.ecommerce.Entity.User;
import com.ecommerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AutoController {

    // Injecting repository to fetch user from database
    @Autowired
    private UserRepository userRepository;

    // This method is called when LOGIN form is submitted
    @PostMapping("/login")
    public String loginUser(
            @RequestParam String email,     // Email from login form
            @RequestParam String password   // Password from login form
    ) {

        // Finding user by email and password from database
        User user = userRepository.findByEmailAndPassword(email, password);

        // If user exists
        if (user != null) {

            // If role is ADMIN, redirect to admin page
            if ("ADMIN".equals(user.getRole())) {
                return "admin";
            }

            // If role is USER, redirect to products page
            return "products";
        }

        // If login fails, return to login page
        return "login";
    }
}


