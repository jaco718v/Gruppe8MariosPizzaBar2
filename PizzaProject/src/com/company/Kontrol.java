package com.company;

import java.util.Scanner;

public class Kontrol {

    private final Scanner keyboard = new Scanner(System.in);
    private boolean running = true;
    private final OrdreHåndtering oh = new OrdreHåndtering();
    private final MenuKort mk = new MenuKort();

    public void run(){
        while(running) {
            valg();
        }
    }

    private void valg(){
        switch (keyboard.nextLine().toLowerCase()) {
            case "input" -> System.out.println("input");
            case "fjern" -> System.out.println("fjern");
            case "menu" -> mk.printMenu();
            case "stop" -> running = false;
            default -> valg();
        }
    }



}
