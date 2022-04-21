package com.company;

import java.util.ArrayList;

public class Bestilling {
  private ArrayList<Pizza> pizzaBestilling = new ArrayList<Pizza>();
  private String kundeNavn;
  private boolean færdigStatus=false;
  private String afhentningsTid;

  public Bestilling(String kundeNavn,String afhentningsTid ){
    this.kundeNavn=kundeNavn;
    this.afhentningsTid=afhentningsTid;
}

  public void setFærdigStatus(boolean færdigStatus) {
    this.færdigStatus = færdigStatus;
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

}
