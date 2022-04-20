package com.company;

public class Pizza {
    private String navn;
    private double pris;

    public Pizza(String name, double price) {
        this.navn = name;
        this.pris = price;
    }

    public String getNavn() {
        return navn;
    }

    public double getPris() {
        return pris;
    }

}
