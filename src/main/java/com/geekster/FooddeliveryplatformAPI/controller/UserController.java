package com.geekster.FooddeliveryplatformAPI.controller;

import com.geekster.FooddeliveryplatformAPI.dto.SignInInput;
import com.geekster.FooddeliveryplatformAPI.dto.SignInOutput;
import com.geekster.FooddeliveryplatformAPI.dto.SignUpOutput;
import com.geekster.FooddeliveryplatformAPI.models.Admin;
import com.geekster.FooddeliveryplatformAPI.models.Order;
import com.geekster.FooddeliveryplatformAPI.models.User;
import com.geekster.FooddeliveryplatformAPI.service.AdminService;
import com.geekster.FooddeliveryplatformAPI.service.OrderService;
import com.geekster.FooddeliveryplatformAPI.service.TokenService;
import com.geekster.FooddeliveryplatformAPI.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TokenService authService;

    @Autowired
    AdminService adminService;

    @Autowired
    OrderService orderService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@Valid @RequestBody User signUpDto) {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public SignInOutput signIn(@Valid @RequestBody SignInInput signInDto) {
        return userService.signIn(signInDto);
    }

    @DeleteMapping("/signout")
    public ResponseEntity<String> signOut(@RequestParam String email, @RequestParam String token) {
        HttpStatus status;
        String msg = null;

        if (authService.authenticate(email, token)) {
            authService.deleteToken(token);
            msg = "Signout Successful";
            status = HttpStatus.OK;

        } else {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg, status);
    }

    @PutMapping()
    public ResponseEntity<String> updateUser(@RequestParam String email, @RequestParam String token, @RequestBody User user) {
        HttpStatus status;
        String msg = null;

        if (authService.authenticate(email, token)) {
            try {
                userService.updateUser(user, token);
                status = HttpStatus.OK;
                msg = "User updated sucessfully";
            } catch (Exception e) {
                msg = "Enter valid information";
                status = HttpStatus.BAD_REQUEST;
            }

        } else {
            msg = "Invalid User";
            status = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<String>(msg, status);
    }


    @GetMapping("/food/menu")
    public ResponseEntity<List<Admin>> getAllFoodItems() {
        List<Admin> menu = adminService.getAllFoods();
        return ResponseEntity.ok(menu);
    }


    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> orders = orderService.getAllOrdersById(userId);
        return ResponseEntity.ok(orders);
    }
}
