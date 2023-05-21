package com.geekster.FooddeliveryplatformAPI.controller;

import com.geekster.FooddeliveryplatformAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/orders")

public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(
            @RequestParam("foodName") String foodName,
            @RequestParam("foodQuantity") int foodQuantity,
            @RequestParam("userId") Long userId) {
        String response;
        HttpStatus status;
        try {
            orderService.createOrder(foodName, foodQuantity, userId);
            response = " your order is placed successfully!!!!";
            status = HttpStatus.CREATED;
        } catch (Exception e) {
            status = HttpStatus.BAD_REQUEST;
            response = " invalid order details!!!";
        }
        return new ResponseEntity<>(response, status);
    }

}
