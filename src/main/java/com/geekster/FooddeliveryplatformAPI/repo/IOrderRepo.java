package com.geekster.FooddeliveryplatformAPI.repo;

import com.geekster.FooddeliveryplatformAPI.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepo extends JpaRepository<Order,Long> {
}
