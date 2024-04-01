package com.example.inventory2;

public class Inventory  {
    private int id;
    private String name;
    private int inv;

    private int cost;
    private int max;

    private int min;

    public Inventory(int id, String name, int inv, int cost, int max, int min) {
        this.id = id;
        this.name = name;
        this.inv = inv;
        this.cost = cost;
        this.max = max;
        this.min = min;

    }

    public static void main(String[] args) {

        try{

            Class.forName("com.mysql.jdbc.Driver");



        }catch(Exception e){
            System.out.println(e.getMessage());
        }
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

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
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
