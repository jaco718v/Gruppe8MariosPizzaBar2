package com.company;

import java.util.ArrayList;

public class Pizza {
    private String navn;
    private double pris;
    private ArrayList<Topping> toppings = new ArrayList<>();

    public Pizza(String name, double price) {
        this.navn = name;
        this.pris = price;
    }

    public Pizza(String navn, double pris, ArrayList<Topping> toppings) {
        this.navn = navn;
        this.pris = pris;
        this.toppings = toppings;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

    public ArrayList<Topping> getToppings() {
        return toppings;
    }

    public void addTopping(Topping topping){
        this.toppings.add(topping);
    }
}
