package com.example.weeklytaskdb1.controller;

import com.example.weeklytaskdb1.model.Fruit;
import com.example.weeklytaskdb1.repository.FruitRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FruitController {
    private final FruitRepository fruitRepo;

    public FruitController(FruitRepository fruitRepo) {
        this.fruitRepo = fruitRepo;
    }

    @GetMapping("/fruits")
    public List<Fruit> getAllFruits() {
        return fruitRepo.findAll();
    }
}
