package lab3;

import java.util.HashMap;
import java.util.Map;

public abstract class Node implements Comparable<Node> {
    private String name;
    private Map<Node, Integer> cost = new HashMap<>();

    public Node() {

    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Node, Integer> getCost() {
        return cost;
    }

    public void setCost(Node node, int value) {
        cost.put(node, value);
        node.cost.put(this, value);
    }

    public void Print(){
        for(Node node : cost.keySet()) {
            System.out.println(this.name + " -- " + node.getName() + " " + cost.get(node));
        }
    }

    public abstract String getType(); //functie abstracta pentru a afla tipul fiecarui nod

    @Override
    public int compareTo(Node other) {
        if (this.name == null || other.name == null) {
            throw new IllegalArgumentException("wrong");
        }
        return this.name.compareTo(other.name);
    }
}
