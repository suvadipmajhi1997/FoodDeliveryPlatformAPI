package com.geekster.FooddeliveryplatformAPI.repo;

import com.geekster.FooddeliveryplatformAPI.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepo extends JpaRepository<Admin,Long> {
}
