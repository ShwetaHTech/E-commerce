package com.ecommerce.Controller;

import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {

    // Injecting ProductRepository to interact with database
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
   public String showProducts(Model model, @RequestParam(required = false)String keyword){
       List<Product> productList;
       if(keyword != null && !keyword.isEmpty()){
           productList = productRepository.findByNameContainingIgnoreCase(keyword);
       }else {
           productList=productRepository.findAll();
       }
       model.addAttribute("products",productList);
       return "products";
   }

    // This method opens the ADD PRODUCT page
    @GetMapping("/admin/add-product")
    public String addProduct(Model model) {

        // Adding empty Product object to bind form data
        model.addAttribute("product", new Product());

        return "add-product"; // add-product.html
    }

    // This method saves product data into database
    @PostMapping("/admin/add-product")
    public String addProduct(@ModelAttribute Product product) {

        // Saving product into database
        productRepository.save(product);

        // Redirecting to admin page after saving
        return "redirect:/products";
    }
}
