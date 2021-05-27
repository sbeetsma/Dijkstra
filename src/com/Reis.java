package com;

import java.util.*;

public class Reis {
    private final Node startNode;
    private final Node eindNode;
    private ArrayList<Node> kortstePad;

    public Reis(Node startNode, Node eindNode){
        this.startNode = startNode;
        this.eindNode = eindNode;
    }
    // leerbron: http://nmamano.com/blog/dijkstra/dijkstra.html
    public void Dijkstra() {
        this.startNode.setBezocht(true);
        this.startNode.setAfstandVanafBegin(0);  // afstand van startpunt naar startpunt is 0
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); // priorityQueue is gebasseerd op totaal gewicht/afstand attribuut van Node
        priorityQueue.add(this.startNode);
        while (!priorityQueue.isEmpty()) {
            Node huidigeNode = priorityQueue.peek();
            for (Stap overgang : huidigeNode.getOvergangen()) {
                Node volgendeNode = overgang.getNaar();
                if (!volgendeNode.isBezocht()) {
                    int nieuweAfstand = huidigeNode.getAfstandVanafBegin() + overgang.getGewicht();
                    if (nieuweAfstand < volgendeNode.getAfstandVanafBegin()) {
                        volgendeNode.setAfstandVanafBegin(nieuweAfstand);
                        volgendeNode.setVoorganger(huidigeNode);
                        priorityQueue.add(volgendeNode);
                    }
                }
            }
            priorityQueue.remove(huidigeNode);
            huidigeNode.setBezocht(true);
        }
    }}
