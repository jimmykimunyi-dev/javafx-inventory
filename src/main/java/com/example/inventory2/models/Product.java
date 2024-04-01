package com.example.inventory2.models;

public class Product {
    private int id;
    private String name;
    private int inventory;
    private int cost;
    private int max;
    private int min;



    public Product(int id, String name, int inventory, int cost, int max, int min) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.cost = cost;
        this.max = max;
        this.min = min;

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

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

}
