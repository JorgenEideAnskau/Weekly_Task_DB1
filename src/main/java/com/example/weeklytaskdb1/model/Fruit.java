package com.example.weeklytaskdb1.model;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Fruit {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String description;
    private String category;
    private String origin;
    private String color;

    private Fruit(String name, String description, String category, String origin, String color) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.origin = origin;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
