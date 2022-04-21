package com.company;

import java.util.ArrayList;

public class OrdreHåndtering {

    private ArrayList<Bestilling> bestillingsListe = new ArrayList<>();
    private ArrayList<Bestilling> ekspederetListe = new ArrayList<>();


    
    public void visBestillingsListe(){
        for (Bestilling bestilling : bestillingsListe) {
            System.out.println(bestilling);
        }
    }
    public void visEkspederetListe(){
        for (Bestilling bestilling : ekspederetListe) {
            System.out.println(bestilling);
        }
    }
}
