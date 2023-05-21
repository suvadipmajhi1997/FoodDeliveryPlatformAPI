package com.geekster.FooddeliveryplatformAPI.service;

import com.geekster.FooddeliveryplatformAPI.models.Admin;
import com.geekster.FooddeliveryplatformAPI.models.Order;
import com.geekster.FooddeliveryplatformAPI.models.User;
import com.geekster.FooddeliveryplatformAPI.repo.IAdminRepo;
import com.geekster.FooddeliveryplatformAPI.repo.IOrderRepo;
import com.geekster.FooddeliveryplatformAPI.repo.IUserRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private IOrderRepo orderRepo;
    @Autowired
    private IUserRepo userRepo;

    @Autowired
    private IAdminRepo adminRepo;

    public Order createOrder( String foodName, int foodQuantity, Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + userId + " not found"));

        Order order = new Order();
        order.setUser(user);
        order.setFoodName(foodName);
        order.setQuantity(foodQuantity);
        return orderRepo.save(order);
    }

    public Optional<Order> getOrderById(Long orderId) {
        return orderRepo.findById(orderId);
    }


    public List<Order> getAllOrders() {
        return orderRepo.findAll();

    }

    public List<Order> getAllOrdersById(Long userId) {
        return orderRepo.findAllById(Collections.singleton(userId));
    }
}
