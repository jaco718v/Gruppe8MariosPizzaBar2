package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Kontrol {

    private final Scanner tastatur = new Scanner(System.in);
    private boolean kører = true;
    private final OrdreHåndtering oh = new OrdreHåndtering();
    private final MenuKort mk = new MenuKort();

    /*
    public MenuKort getMk() {
        return mk;
    }

     */

    public void loadPizza() throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File("menu.csv"));
        while(fileScanner.hasNextLine()){
            String line = fileScanner.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(",").useLocale(Locale.ENGLISH); //Semicolon virker igen ikke?
            String navn = lineScanner.next();
            double pris = lineScanner.nextDouble();
            mk.getMenu().add(new Pizza(navn,pris));
        }
    }


    public void kør() throws FileNotFoundException {
        loadPizza();
        while(kører) {
            visInformation();
            valg();
        }
    }

    private void valg(){
        String[] input = tastatur.nextLine().toLowerCase().split(" ",2);
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
            case "3","ekspederet" -> visEkspederet();
            case "4","menu" -> mk.printMenu();
            case "5","stop" -> kører = false;
            default -> valg();
        }
    }

    private void visInformation() {
        System.out.println("""
                ------------------------------------------------------------------
                1. 'input' - for at lægge en bestilling ind
                2. 'ekspedere + <ordreNummer>'- for at fjerne en ordre til ekspederet
                3. 'ekspederet' - for vise ekspederet bestillinger
                4. 'menu' - for at vise pizza menu'en
                5. 'stop' - for at stoppe programmet
                ------------------------------------------------------------------
                """);
        oh.visBestillingsListe();
    }


    private void visEkspederet() {

        System.out.println("ekspederet ordre:");
        oh.visEkspederetListe();

    }
}
