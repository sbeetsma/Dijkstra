package com;

import java.util.*;
// nodes for graph
public class Node implements Comparable<Node> {
    private String naam;
    private Node voorganger;
    private double gewichtVanafBegin = Integer.MAX_VALUE;
    private boolean bezocht;

    public Node(String naam) {
        this.naam = naam;
    }

    private ArrayList<Stap> overgangen = new ArrayList<>(); // alle overgangen

    public double getGewichtVanafBegin() {
        return gewichtVanafBegin;
    }

    public void setGewichtVanafBegin(double gewichtVanafBegin) {
        this.gewichtVanafBegin = gewichtVanafBegin;
    }

    public boolean isBezocht() {
        return bezocht;
    }

    public void setBezocht(boolean bezocht) {
        this.bezocht = bezocht;
    }

    public ArrayList<Stap> getOvergangen() {
        return overgangen;
    }

    public void setOvergangen(ArrayList<Stap> overgangen) {
        this.overgangen = overgangen;
    }

    public void setVoorganger(Node voorganger) {
        this.voorganger = voorganger;
    }

    public Node getVoorganger() {
        return voorganger;
    }

    @Override
    public String toString() {
        return this.naam;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.gewichtVanafBegin, o.gewichtVanafBegin);
    }
}