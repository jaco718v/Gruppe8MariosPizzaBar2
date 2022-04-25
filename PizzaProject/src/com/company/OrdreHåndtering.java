package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class OrdreHåndtering {

    private ArrayList<Bestilling> bestillingsListe = new ArrayList<>();
    private ArrayList<Bestilling> ekspederetListe = new ArrayList<>();
    private int ordreNummer = 1;

    public void visBestillingsListe() {
        if (bestillingsListe.size() != 0) {
            System.out.println("nuværrende bestillinger");
            System.out.println("______________________________________");
            for (Bestilling bestilling : bestillingsListe) {
                bestilling.visBestilling();
                System.out.println("______________________________________");
            }
        }
    }



    public void visEkspederetListe() {
        System.out.println("______________________________________");
        for (Bestilling bestilling : ekspederetListe) {
            bestilling.visBestilling();
            System.out.println("______________________________________");
        }
    }


    public void opretBestilling(MenuKort menu) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indtast kundens navn");
        String kundeNavn = sc.nextLine();
        System.out.println("Indtast afhentningstid");
        String afhentningstid = sc.nextLine();
        bestillingsListe.add(new Bestilling(ordreNummer, kundeNavn, afhentningstid));
        String pizzaInput = null;
        System.out.println("Indtast antal og pizzaens navn");
        while (pizzaInput == (null) || !pizzaInput.equalsIgnoreCase("færdig")) {
            pizzaInput = sc.nextLine();
            if (!pizzaInput.equalsIgnoreCase("færdig")) {
                int pizzaAntal = talFinder(pizzaInput);
                if (pizzaAntal > 1) {
                    pizzaInput = pizzaInput.substring(pizzaInput.indexOf(' ') + 1);
                }
                if (tilføjPizza(menu, pizzaInput, bestillingsListe.get(bestillingsListe.size() - 1))) {
                    System.out.println(pizzaAntal + " " + pizzaInput + " registreret");
                    bestillingsListe.get(bestillingsListe.size() - 1).lægtilPizzaAntal(pizzaAntal);
                } else {
                    System.out.println(pizzaInput + " findes ikke i menuen");
                }
                System.out.println("Indtast næste ordre eller indtast \"færdig\"");
            }
        }
        System.out.println("Ordre er oprettet");
        ordreNummer++;
    }

    public boolean tilføjPizza(MenuKort menu, String pizzaName, Bestilling bestilling) {
        for (Pizza pizza : menu.skafMenu()) {
            if (pizzaName.equalsIgnoreCase(pizza.skafNavn())) {
                bestilling.lægtilPizza(pizza);
                return true;
            }
        }
        return false;
    }

    public int talFinder(String pizza) {     //Virker kun ved 1 og 2-cifret antal
        if (!(pizza.charAt(0) == ' ') && (int) pizza.charAt(0) - (int) 'a' < 0) {
            if (!(pizza.charAt(1) == ' ') && (int) pizza.charAt(1) - (int) 'a' < 0) {
                return (pizza.charAt(0) - '0') * 10 + (pizza.charAt(1) - '0');
            }
            return pizza.charAt(0) - '0';
        }
        return 1;
    }

    public void færdiggørOrdre(int ordrenummer) {
        boolean ordreFundet = false;
        for (int i = 0; bestillingsListe.size() > i; i++) {
            if (ordrenummer == bestillingsListe.get(i).skafOrdreNummer()) {
                ekspederetListe.add(bestillingsListe.get(i));
                bestillingsListe.remove(bestillingsListe.get(i));
                System.out.println("Bestilling ekspederet");
                ordreFundet = true;
            }
        }
        if (!ordreFundet) {
            System.out.println("Ordre nummer: " + ordrenummer + " findes ikke.");
        }

    }
}
