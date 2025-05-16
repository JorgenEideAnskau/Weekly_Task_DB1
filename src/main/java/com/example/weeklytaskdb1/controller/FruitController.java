package com.example.weeklytaskdb1.controller;

import com.example.weeklytaskdb1.model.Fruit;
import com.example.weeklytaskdb1.repository.FruitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PutMapping("/fruits/{id}")
    public Fruit updateFruit(@PathVariable int id, @RequestBody Fruit updatedFruit) {
        Optional<Fruit> existingFruit = fruitRepo.findById(id);
        if (existingFruit.isPresent()) {
            Fruit fruit = existingFruit.get();
            fruit.setName(updatedFruit.getName());
            fruit.setDescription(updatedFruit.getDescription());
            fruit.setCategory(updatedFruit.getCategory());
            fruit.setOrigin(updatedFruit.getOrigin());
            fruit.setColor(updatedFruit.getColor());
            return fruitRepo.save(fruit);
        } else {
            throw new RuntimeException("Fruit not found");
        }
    }

//    @PostMapping("/fruits")
//    public Fruit addFruit(@RequestBody Fruit newFruit) {
//        return fruitRepo.save(newFruit);
//    }

    @DeleteMapping("/fruits/{id}")
    public Fruit deleteFruit(@PathVariable int id) {
        Optional<Fruit> existingFruit = fruitRepo.findById(id);
        if (existingFruit.isPresent()) {
            fruitRepo.delete(existingFruit.get());
            return existingFruit.get();
        } else {
            throw new RuntimeException("Fruit not found");
        }
    }
}