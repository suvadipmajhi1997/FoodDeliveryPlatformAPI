package com.geekster.FooddeliveryplatformAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Table(name = "user_Order")
    @Entity

    public class Order {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long orderId;

        @NotBlank(message = "food name Required")
        private String foodName;

        @NotBlank(message = "Quantity Required")
        private int Quantity;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User user;


}
