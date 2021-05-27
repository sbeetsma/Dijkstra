package com;

public class Main {
    public static void main(String[] args){
        Node s0 = new Node("Locatie_1");
        Node s1 = new Node("Locatie_2");
        System.out.println(s0.getNeighbors());
        s0.addNeighbor(s1, 4);
        System.out.println(s0.getNeighbors());
    }
}
