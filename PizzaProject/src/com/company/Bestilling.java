package com.company;

import java.util.ArrayList;

public class Bestilling {
  private ArrayList<Pizza> pizzaBestilling = new ArrayList<Pizza>();
  private ArrayList<Integer> pizzaAntal = new ArrayList<>();
  private String kundeNavn;
  private String afhentningsTid;
  private int ordrenummer;

  public Bestilling(int ordrenummer, String kundeNavn,String afhentningsTid ){
    this.ordrenummer=ordrenummer;
    this.kundeNavn=kundeNavn;
    this.afhentningsTid=afhentningsTid;
}

  public void lægtilPizza(Pizza pizza){
    pizzaBestilling.add(pizza);
}

  public String skafKundeNavn() {
    return kundeNavn;
  }

  public String skafAfhentningsTid() {
    return afhentningsTid;
  }

  public ArrayList<Pizza> skafPizzaBestilling() {
    return pizzaBestilling;
  }

  public int skafOrdreNummer() {
    return ordrenummer;
  }

  public void lægtilPizzaAntal(int antal){
    pizzaAntal.add(antal);
  }

  public double skafTotal() {
    double price = 0;
    for (int i = 0; i < pizzaBestilling.size(); i++) {
      price += pizzaBestilling.get(i).skafPris() * pizzaAntal.get(i);
    }
    return price;
  }


  public void visBestilling(){
    System.out.println("Ordrenummer: "+ordrenummer);
    System.out.println("Bestilling til "+kundeNavn);
    System.out.println("Pizzaer inkluderet i bestilling:");
    for(int i =0; pizzaBestilling.size()>i;i++){
      int lineLength = 25;
      String fillerText = " ";
      System.out.printf("%11s x %2d   %.2fkr \n",
          pizzaBestilling.get(i).skafNavn(),
          pizzaAntal.get(i),
          //fillerText.repeat(lineLength-pizzaBestilling.get(i).getNavn().length()-Double.toString(pizzaBestilling.get(i).getPris()*pizzaAntal.get(i)).length()),
          pizzaBestilling.get(i).skafPris()*pizzaAntal.get(i));
    }
      System.out.printf("Total:  %17.2fkr\n", skafTotal());
      System.out.println("Afhentes "+afhentningsTid);
  }
}
