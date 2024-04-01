package com.example.inventory2.models;

public class Part {
    private int id;
    private String name;
    private int inventory;
    private double cost;
    private int max;
    private int min;
    private int machineId;


    public Part(int id, String name, int inventory, double cost, int max, int min, int machineId) {
        this.id = id;
        this.name = name;
        this.inventory = inventory;
        this.cost = cost;
        this.max = max;
        this.min = min;
        this.machineId = machineId;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
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

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
