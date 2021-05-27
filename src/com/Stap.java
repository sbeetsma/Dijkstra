package com;

public class Stap {
    private int gewicht;
    private Node van;
    private Node naar;

    public Stap(Node van, Node naar, int gewicht){
        this.naar = naar;
        this.van = van;
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    public Node getVan(){
        return van;
    }
    public Node getNaar() {
        return naar;
    }


}


