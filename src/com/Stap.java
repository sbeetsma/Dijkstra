package com;

public class Stap {

    private final int gewicht;
    private final Node naar;

    public Stap(Node naar, int gewicht){
        this.naar = naar;
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Node getNaar() {
        return naar;
    }


}


