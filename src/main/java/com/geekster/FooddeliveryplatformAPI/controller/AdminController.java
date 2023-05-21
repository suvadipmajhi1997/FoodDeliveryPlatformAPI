package com.geekster.FooddeliveryplatformAPI.controller;

import com.geekster.FooddeliveryplatformAPI.models.Admin;
import com.geekster.FooddeliveryplatformAPI.models.Order;
import com.geekster.FooddeliveryplatformAPI.service.AdminService;
import com.geekster.FooddeliveryplatformAPI.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/food")
public class AdminController {

    @Autowired
    AdminService adminService;

   @Autowired
    OrderService orderService;

    @PostMapping("/admin/foodItems")
    public ResponseEntity<String> addFoodItem(@Valid @RequestBody Admin foodItem) {
        Admin foodObj=adminService.createFood(foodItem);
        return ResponseEntity.ok("Food item added successfully.");
    }
      @GetMapping("/get")
        public ResponseEntity<List<Admin>>GetAllFoods(){
            List<Admin>foods=adminService.getAllFoods();
            return new ResponseEntity<>(foods,HttpStatus.OK);
        }


    @GetMapping("/id/{foodId}")
    public ResponseEntity<Admin>getFoodById(@PathVariable Long foodId){
        Optional<Admin> getFood=adminService.getFoodById(foodId);
        return getFood.map(value->new ResponseEntity<>(value,HttpStatus.FOUND))
                .orElseGet(()->new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/admin/foodItems/{foodItemId}")
    public ResponseEntity<Admin> updateFoodItem(@Valid @PathVariable Long foodItemId, @RequestBody Admin foodItem) {
        Optional<Admin> existFood = adminService.getFoodById(foodItemId);
        if (existFood.isPresent()) {
            foodItem.setFoodId(foodItemId);
            Admin update=adminService.updatefood(foodItem);
            return new ResponseEntity<>(update,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/admin/foodItems/{foodItemId}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
        Optional<Admin> existFood = adminService.getFoodById(foodItemId);
        if (existFood.isPresent()) {
     adminService.deleteFoodItemById(foodItemId);
     return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/admin/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<com.geekster.FooddeliveryplatformAPI.models.Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }
}
