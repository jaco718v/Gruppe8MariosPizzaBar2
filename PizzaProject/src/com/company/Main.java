package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private ArrayList<Bestilling> bestillingsListe;
    private int ordrenummer=0;
    MenuKort menukort = new MenuKort();

    public static void main(String[] args) {
        //new Kontrol().run(); 
	      new Main().run();
    }

    public void run() {
        bestillingsListe = new ArrayList<>();
        opretBestilling();
       //menukort.printMenu();
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
                System.out.println(addBestillingPizza(pizzNavn,bestillingsListe.get(ordrenummer)));
                System.out.println("Indtast næste ordre eller indtast \"færdig\"");
            }
        }
        System.out.println("Ordre er oprettet");
        ordrenummer++;
    }

    public String addBestillingPizza(String pizzaName, Bestilling bestilling){
        for(Pizza pizza : menukort.getMenu()){
            if(pizzaName.equalsIgnoreCase(pizza.getNavn())){
                bestilling.addPizza(pizza);
                return pizza.getNavn()+" registreret til bestilling";
            }
        }
        return "Pizzaen findes ikke i menuen";
    }

    public void showBestilling(Bestilling bestilling){
        System.out.println("Bestilling til "+bestilling.getKundeNavn());
        System.out.println("Pizzaer inkluderet i bestilling:");
        for(Pizza pizza : bestilling.getPizzaBestilling()){
            System.out.println(pizza.getNavn());
        }
        System.out.println("Afhentes "+bestilling.getAfhentningsTid());
    }
}
