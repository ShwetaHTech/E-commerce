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

    @GetMapping("/products")
    public String products() {
        return "products";
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

    @GetMapping("/cart")
    public String cart() {
        return "cart";
    }

    @GetMapping("/admin/add-product")
    public String addProduct() {
        return "add-product";
    }

    @GetMapping("/admin/delete-product")
    public String deleteProduct() {
        return "delete-product";
    }
}
