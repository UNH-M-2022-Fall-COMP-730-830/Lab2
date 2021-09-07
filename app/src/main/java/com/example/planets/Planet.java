package com.example.planets;

import androidx.annotation.DrawableRes;

public class Planet {

    // Encapsulate the class attributes by making them private

    private String name;
    @DrawableRes private int image;
    private double surfaceGravity;

    // constructor
    public Planet(String name, int image, double surfaceGravity) {
        this.name = name;
        this.image = image;
        this.surfaceGravity = surfaceGravity;
    }

    // Implement only Getters to the Planet properties read only

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double calculateWeight(double mass) {
        return mass * surfaceGravity;
    }
}
