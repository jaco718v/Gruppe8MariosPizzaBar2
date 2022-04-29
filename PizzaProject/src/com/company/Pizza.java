package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Pizza {
    private String navn;
    private double pris;

    public Pizza(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public String skafNavn() {
        return navn;
    }

    public double skafPris() {
        return pris;
    }

    /*
    public void pizzaSave(PrintStream out) throws FileNotFoundException {
            out.print(skafNavn());
            out.print(","); //Virker ikke med semicolon???
            out.print(skafPris());
            out.println();
        }

     */

}
