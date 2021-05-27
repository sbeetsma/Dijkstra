package com;

public class Stap{

    private final double gewicht;
    private final Node bestemming;

    public Stap(Node naar, double gewicht){
        this.bestemming = naar;
        this.gewicht = gewicht;
    }

    public double getGewicht() {
        return gewicht;
    }

    public Node getBestemming() {
        return bestemming;

    }



}


