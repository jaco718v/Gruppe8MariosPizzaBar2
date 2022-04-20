package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private ArrayList<Pizza> menu;
    private ArrayList<Bestilling> bestillingsListe;
    private int ordrenummer=0;

    public Controller() {
        bestillingsListe =new ArrayList<>();
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

        for (Pizza pizza : menu) {
            int lineLength = 40;
            String fillerText = ".";
            System.out.printf("%s %s %.0f,- \n"
                ,pizza.getName()
                ,fillerText.repeat(lineLength-pizza.getName().length())
                ,pizza.getPrice());
        }

    }


    public void opretBestilling(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast kundens navn");
        String kundeNavn = sc.nextLine();
        System.out.println("Indtast afhentningstid");
        String afhentningstid = sc.nextLine();
        bestillingsListe.add(new Bestilling(kundeNavn,afhentningstid));
        String pizzNavn = null;
        System.out.println("Indtast pizzaens navn");
        while(pizzNavn==(null) ||!pizzNavn.equalsIgnoreCase("færdig")){
            pizzNavn = sc.nextLine();
            if(!pizzNavn.equalsIgnoreCase("færdig")){
            System.out.println(addPizza(pizzNavn,bestillingsListe.get(ordrenummer)));
            System.out.println("Indtast næste ordre eller indtast \"færdig\"");
            }
        }
        System.out.println("Ordre er oprettet");
        ordrenummer++;
    }

    public String addPizza(String pizzaName, Bestilling bestilling){
        for(Pizza pizza : menu){
            if(pizzaName.equalsIgnoreCase(pizza.getName())){
                bestilling.addPizza(pizza);
                return pizza.getName()+" registreret til bestilling";
            }
        }
        return "Pizzaen findes ikke i menuen";
    }

    public void showBestilling(Bestilling bestilling){
        System.out.println("Bestilling til "+bestilling.getKundeNavn());
        System.out.println("Pizzaer inkluderet i bestilling:");
        for(Pizza pizza : bestilling.getPizzaBestilling()){
            System.out.println(pizza.getName());
        }
        System.out.println("Afhentes "+bestilling.getAfhentningsTid());
    }

}
