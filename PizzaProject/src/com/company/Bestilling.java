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

  public void addPizza(Pizza pizza){
    pizzaBestilling.add(pizza);
}

  public String getKundeNavn() {
    return kundeNavn;
  }

  public String getAfhentningsTid() {
    return afhentningsTid;
  }

  public ArrayList<Pizza> getPizzaBestilling() {
    return pizzaBestilling;
  }

  public int getOrdrenummer() {
    return ordrenummer;
  }

  public void addPizzaAntal(int antal){
    pizzaAntal.add(antal);
  }

  public void visBestilling(){
    System.out.println("Ordrenummer: "+ordrenummer);
    System.out.println("Bestilling til "+kundeNavn);
    System.out.println("Pizzaer inkluderet i bestilling:");
    for(int i =0; pizzaBestilling.size()>i;i++){
      int lineLength = 25;
      String fillerText = " ";
      System.out.printf("%d \t %s %s %.2fkr\n",
          pizzaAntal.get(i),
          pizzaBestilling.get(i).getNavn(),
          fillerText.repeat(lineLength-pizzaBestilling.get(i).getNavn().length()-Double.toString(pizzaBestilling.get(i).getPris()*pizzaAntal.get(i)).length()),
          pizzaBestilling.get(i).getPris()*pizzaAntal.get(i));
    }
    System.out.println("Afhentes "+afhentningsTid);
  }
}
