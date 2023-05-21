package com.geekster.FooddeliveryplatformAPI.service;

import com.geekster.FooddeliveryplatformAPI.models.Admin;
import com.geekster.FooddeliveryplatformAPI.repo.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    IAdminRepo adminRepo;

    public Admin createFood(Admin foodItem) {
        return adminRepo.save(foodItem);
    }

    public Optional<Admin> getFoodById(Long id) {
        return adminRepo.findById(id);
    }

    public void deleteFoodItemById(Long foodItemId) {
        adminRepo.deleteById(foodItemId);
    }

    public Admin updatefood(Admin foodItem) {
        return adminRepo.save(foodItem);
    }

    public List<Admin> getAllFoods() {
        return adminRepo.findAll();
    }
}
