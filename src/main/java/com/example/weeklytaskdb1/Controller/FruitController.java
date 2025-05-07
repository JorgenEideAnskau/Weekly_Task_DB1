package com.example.weeklytaskdb1.Controller;

import com.example.weeklytaskdb1.Repository.FruitFruitRepository;
import com.example.weeklytaskdb1.model.Fruit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fruits")
public class FruitController {
    private final FruitFruitRepository repository;

    public FruitController(FruitFruitRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Fruit> getAllFruits() {
        return repository.getAllFruits();
    }
}