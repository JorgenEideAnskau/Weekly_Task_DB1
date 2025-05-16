package com.example.weeklytaskdb1.repository;

import com.example.weeklytaskdb1.model.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {
    // Custom query methods can be defined here if needed
}