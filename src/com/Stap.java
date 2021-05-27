package com;

public class Stap {

    private final int gewicht;
    private final Node bestemming;

    public Stap(Node naar, int gewicht){
        this.bestemming = naar;
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Node getBestemming() {
        return bestemming;

    }



}


