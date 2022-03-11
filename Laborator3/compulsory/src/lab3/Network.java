package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Network {
    private List<Node> nodes = new ArrayList<>();

    public Network() {

    }

    public Network(List<Node> nodes) {
        this.nodes = nodes;
        Collections.sort(nodes);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
        Collections.sort(nodes);
    }

    public void addNode(Node node) {
        nodes.add(node);
        Collections.sort(nodes);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(nodes.size());
        for (Node n : nodes) {
            s.append(n.getName());
            s.append('\n');
        }

        return s.toString();
    }
}
