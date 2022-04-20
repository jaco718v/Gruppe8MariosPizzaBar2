package com.company;

import java.util.ArrayList;

public class MenuKort {
    private ArrayList<Pizza> menu;

    public MenuKort() {
        menu = new ArrayList<>();
        menu.add(new Pizza("Vesuvio",57));
        menu.add(new Pizza("Amerikaner",53));
        menu.add(new Pizza("Cacciatore",57));
        menu.add(new Pizza("Carbona",63));
        menu.add(new Pizza("Dennis",65));
        menu.add(new Pizza("Bertil",57));
        menu.add(new Pizza("Silvia",61));
        menu.add(new Pizza("Victoria",61));
        menu.add(new Pizza("Toronfo",61));
        menu.add(new Pizza("Capricciosa",61));
        menu.add(new Pizza("Hawaii",61));
        menu.add(new Pizza("La Blissola",61));
        menu.add(new Pizza("Venezia",61));
        menu.add(new Pizza("Mafia",61));
    }



    public void printMenu(){
        for (int i = 0; i < menu.size(); i++) {
            int lineLength = 40;
            String fillerText = ".";
            System.out.printf("%2s. %s %s %.0f,- \n"
                ,i+1
                ,menu.get(i).getNavn()
                ,fillerText.repeat(lineLength-menu.get(i).getNavn().length())
                ,menu.get(i).getPris());
        }
    }
}
