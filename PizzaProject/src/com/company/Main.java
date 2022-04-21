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
        String pizzaNavn = null;
        System.out.println("Indtast pizzaens navn");
        while(pizzaNavn==(null) ||!pizzaNavn.equalsIgnoreCase("færdig")){
            pizzaNavn = sc.nextLine();
            if(!pizzaNavn.equalsIgnoreCase("færdig")){
                int pizzaAntal = talFinder(pizzaNavn);
                if(pizzaAntal>1){
                    pizzaNavn=pizzaNavn.substring(2);
                }
                if(addBestillingPizza(pizzaNavn,bestillingsListe.get(ordrenummer))){
                    System.out.println(pizzaAntal+" "+pizzaNavn+" registreret");
                    bestillingsListe.get(ordrenummer).addPizzaAntal(pizzaAntal);
                }
                else{
                    System.out.println(pizzaNavn+" findes ikke i menuen");
                }

                System.out.println("Indtast næste ordre eller indtast \"færdig\"");
            }
        }
        System.out.println("Ordre er oprettet");
        ordrenummer++;
    }

    public boolean addBestillingPizza(String pizzaName, Bestilling bestilling){
        for(Pizza pizza : menukort.getMenu()){
            if(pizzaName.equalsIgnoreCase(pizza.getName())){
                bestilling.addPizza(pizza);
                return true;
            }
        }
        return false;
    }

    public int talFinder(String pizza){     //Virker kun ved 1-cifret antal
        if((int)pizza.charAt(0)-(int)'a' < 0){
            return pizza.charAt(0)-'0';
            }
        return 1;
    }
}
