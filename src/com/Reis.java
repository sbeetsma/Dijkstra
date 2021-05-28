package com;

import java.util.*;

public class Reis implements Comparable<Reis> {
    private ArrayList<Node> kortstePad;
    private double totaalGewicht = 0;

    public Reis(Node startNode, Node eindNode){
        // voor elke nieuwe reis wordt opnieuw uitgerekend voor elke node wat zijn kortste pad is;
        dijkstra(startNode);
        // totaal gewicht wordt in KorstePad ook geupdate
        this.kortstePad = kortstePad(eindNode);
        this.totaalGewicht = eindNode.getAfstandVanafBegin();
    }
    public ArrayList<Node> getKortstePad() {
        return kortstePad;

    }

    public double getTotaalGewicht() {
        return totaalGewicht;
    }

    // leerbron: http://nmamano.com/blog/dijkstra/dijkstra.html
    public void dijkstra(Node startPunt){
        startPunt.setBezocht(true);
        startPunt.setAfstandVanafBegin(0);  // afstand van startpunt naar startpunt is 0
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(); // priorityQueue gebasseerd op totaal gewicht/afstand attribuut van Node
        priorityQueue.add(startPunt);
        while (!priorityQueue.isEmpty()){
            Node huidigeNode = priorityQueue.poll();
            for(Stap overgang : huidigeNode.getOvergangen()){Node volgendeNode = overgang.getBestemming();
                if (!volgendeNode.isBezocht()) {this.totaalGewicht = huidigeNode.getAfstandVanafBegin()+overgang.getGewicht();
                    if(this.totaalGewicht<volgendeNode.getAfstandVanafBegin()){
                        volgendeNode.setAfstandVanafBegin(this.totaalGewicht);
                        volgendeNode.setVoorganger(huidigeNode);
                        priorityQueue.add(volgendeNode);
                    }
                }

            }
            priorityQueue.remove(huidigeNode);
            huidigeNode.setBezocht(true);
        }
    }

        // method die het kortste pad returned vanaf een target node gebasseerd op de eerder uitgerekende,


        public ArrayList<Node> kortstePad(Node target){
            ArrayList<Node> pad = new ArrayList<>(Collections.singletonList(target));

            while (target.getVoorganger() != null) {
                pad.add(target.getVoorganger());
                target = Objects.requireNonNull(target).getVoorganger();
            }
    Collections.reverse(pad);
    return pad;
    }

    @Override
    public int compareTo(Reis o) {
        return Double.compare(this.totaalGewicht, o.totaalGewicht);
    }



}
