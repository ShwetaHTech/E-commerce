package com.ecommerce.Controller;

import com.ecommerce.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "Index";
    }



    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


@GetMapping("/admin")
public String admin(){
        return "admin";
}

    @GetMapping("/admin/delete-product")
    public String deleteProduct() {
        return "delete-product";
    }

//    @GetMapping("/admin/add-product")
//    public String addProduct() {
//        return "add-product";
//    }


}
