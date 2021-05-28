package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args){
    Node node0 = new Node("A");
    Node node1 = new Node("B");
    Node node2 = new Node("C");
    Node node3 = new Node("D");

    node0.setOvergangen(new ArrayList<>(Arrays.asList(new Stap(node1, 10), new Stap(node2, 3))));
    node1.setOvergangen(new ArrayList<>(Collections.singletonList(new Stap(node3, 7))));
    node2.setOvergangen(new ArrayList<>(Collections.singletonList(new Stap(node3, 6))));

    Reis test = new Reis(node0, node3);
    System.out.println(test.getKortstePad());
    System.out.println(test.getTotaalGewicht());

    }
}
