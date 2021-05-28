package com;

public class Vlucht extends Stap{
    public Vlucht(Node naar, double prijs) {
        // door +50 bij het gewicht is het negatieve filter om routes met veel overgangen extra nadeel te geven (bagage verlies)
        super(naar, prijs+50);
    }
}
