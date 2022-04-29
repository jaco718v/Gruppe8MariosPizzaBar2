package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class MenuKort {
    private ArrayList<Pizza> menu = new ArrayList<>();;

    public ArrayList<Pizza> getMenu() {
        return menu;
    }

    /*
    public void pizzaSave() throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("menu.csv"));
        for(Pizza pizza : menu){
            pizza.pizzaLoad(out);
        }
    }

     */



    public void printMenu(){
        for (int i = 0; i < menu.size(); i++) {
            int lineLength = 40;
            String fillerText = ".";
            System.out.printf("%2s. %s %s %.0f,- \n"
                ,i+1
                ,menu.get(i).skafNavn()
                ,fillerText.repeat(lineLength-menu.get(i).skafNavn().length())
                ,menu.get(i).skafPris());
        }

    }

    public ArrayList<Pizza> skafMenu() {
        return menu;
    }
}
