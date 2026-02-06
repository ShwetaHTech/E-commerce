package com.ecommerce.Controller;

import com.ecommerce.Entity.CartItem;
import com.ecommerce.Entity.Order;
import com.ecommerce.Repository.CartItemRepository;
import com.ecommerce.Repository.OrderRepository;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Value("${razorpay.key.id}")
    private String razorpayKeyId;

    @Value("${razorpay.key.secret}")
    private String razorpaySecret;

    // CHECKOUT PAGE
    @GetMapping("/checkout")
    public String checkoutPage(Model model) {

        List<CartItem> cartItems = cartItemRepository.findAll();

        double total = 0;
        for (CartItem item : cartItems) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("total", total);
        model.addAttribute("order", new Order());
        return "checkout";
    }

    // PLACE ORDER (COD)
//    @PostMapping("/place-order")
//    public String placeOrder(
//            @ModelAttribute Order order,
//            @RequestParam("paymentMethod") String paymentMethod
//    ) {
//
//        try {
//            List<CartItem> cartItems = cartItemRepository.findAll();
//
//            double total = 0;
//            for (CartItem item : cartItems) {
//                total += item.getProduct().getPrice() * item.getQuantity();
//            }
//
//            order.setItems(cartItems);
//            order.setTotalAmount(total);
//            order.setOrderDate(LocalDateTime.now());
//            order.setPaymentMethod(paymentMethod);
//
//            orderRepository.save(order);
//            cartItemRepository.deleteAll();
//
//            return "redirect:/order-success";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//    }


    @PostMapping("/place-order")
    public String placeOrder(
            @ModelAttribute Order order,
            @RequestParam("paymentMethod") String paymentMethod
    ) {
        try {
            List<CartItem> cartItems = cartItemRepository.findAll();

            double total = 0;
            for (CartItem item : cartItems) {
                total += item.getProduct().getPrice() * item.getQuantity();
            }


            order.setTotalAmount(total);
            order.setOrderDate(LocalDateTime.now());
            order.setPaymentMethod(paymentMethod);

            orderRepository.save(order);
            cartItemRepository.deleteAll();

            return "redirect:/order-success";

        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }



    //  CREATE RAZORPAY ORDER
    @PostMapping("/create-razorpay-order")
    @ResponseBody
    public Map<String, Object> createRazorpayOrder() throws Exception {

        RazorpayClient client =
                new RazorpayClient(razorpayKeyId, razorpaySecret);

        JSONObject options = new JSONObject();
        options.put("amount", 50000); // 500 INR = 50000 paise
        options.put("currency", "INR");
        options.put("receipt", "order_rcptid_11");

        com.razorpay.Order razorpayOrder =
                client.orders.create(options);

        Map<String, Object> response = new HashMap<>();
        response.put("id", razorpayOrder.get("id"));
        response.put("amount", razorpayOrder.get("amount"));

        return response;
    }

    //  PAYMENT SUCCESS
    @PostMapping("/payment-success")
    public String paymentSuccess() {
        return "redirect:/order-success";
    }

    //  SUCCESS PAGE
    @GetMapping("/order-success")
    public String orderSuccess() {
        return "order-success";
    }
}

