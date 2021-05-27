package com;

import java.util.HashMap;
import java.util.Map;

public class Node {
    final String label;
    private Map<Node, Integer> neighbors = new HashMap<>();

    public Node(String label) {
        this.label = label;
    }

    public void addNeighbor(Node node, int distance){
        this.neighbors.put(node, distance);
    }

    public Map<Node, Integer> getNeighbors(){
        return this.neighbors;
    }






}
