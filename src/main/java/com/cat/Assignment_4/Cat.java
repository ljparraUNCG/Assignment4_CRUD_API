package com.cat.Assignment_4;


import jakarta.persistence.*;

@Entity
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private String breed;
    private String diet;
    private String home;

    // Constructors
    public Cat() {}

    public Cat(String name, String description, String breed, String diet, String home) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.diet = diet;
        this.home = home;
    }

    // Getters and Setters
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
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

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }
}