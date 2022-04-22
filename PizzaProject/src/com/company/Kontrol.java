package com.company;

import java.util.Scanner;

public class Kontrol {

    private final Scanner keyboard = new Scanner(System.in);
    private boolean running = true;
    private final OrdreHåndtering oh = new OrdreHåndtering();
    private final MenuKort mk = new MenuKort();

    public void run(){
        while(running) {
            visInformation();
            valg();
        }
    }

    private void valg(){
        String[] input = keyboard.nextLine().toLowerCase().split(" ",2);
        switch (input[0]) {
            case "1","input" -> oh.opretBestilling(mk);
            case "2","ekspedere" -> {

                // ParseInt problemstilling hvis Alfonso skriver andet end tal
                if (input.length == 1 || input[1].isEmpty()) {
                    System.out.println("Du mangler at skrive et tal efterfølgende.");
                } else {
                    oh.færdiggørOrdre(Integer.parseInt(input[1]));
                }
            }
            case "3","menu" -> mk.printMenu();
            case "4","stop" -> running = false;
            default -> valg();
        }
    }

    private void visInformation() {
        System.out.println("""
                ------------------------------------------------------------------
                1. 'input' - for at lægge en bestilling ind
                2. 'ekspedere + <ordreNummer>'- for at fjerne en ordre til ekspederet
                3. 'menu' - for at vise pizza menu'en
                4. 'stop' - for at stoppe programmet
                ------------------------------------------------------------------
                """);
        System.out.println("nuværrende ordre:");
        oh.visBestillingsListe();

        System.out.println("ekspederet ordre:");
        oh.visEkspederetListe();
    }

}
