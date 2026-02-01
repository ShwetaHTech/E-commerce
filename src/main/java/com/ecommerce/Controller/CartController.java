package com.ecommerce.Controller;

import com.ecommerce.Entity.CartItem;
import com.ecommerce.Entity.Product;
import com.ecommerce.Repository.CartItemRepository;
import com.ecommerce.Repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {

    // ✅ FIX 1: Correct Logger (SLF4J)
    private static final Logger log = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    // ✅ FIX 2: Mapping
    @GetMapping("/cart")
    public String viewCart(Model model) {

        log.info("Viewing cart");

        List<CartItem> cartItems = cartItemRepository.findAll();
        double total = 0;

        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);

        return "cart";
    }


    @PostMapping("/cart/add/{productId}")
    public String addToCart(@PathVariable Long productId) {

        log.info("Adding product to cart: {}", productId);

        Product product = productRepository.findById(productId).orElse(null);

        if (product != null) {
            CartItem item = new CartItem();
            item.setProduct(product);
            item.setQuantity(1);
            cartItemRepository.save(item);
        }

        return "redirect:/cart";
    }

    // Increase Quantity
    @GetMapping("/cart/increase/{id}")
    public String increaseQuantity(@PathVariable Long id) {

        CartItem item = cartItemRepository.findById(id).orElse(null);

        if (item != null) {
            item.setQuantity(item.getQuantity() + 1);
            cartItemRepository.save(item);
        }

        return "redirect:/cart";
    }



}
