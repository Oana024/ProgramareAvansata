package lab3;

public abstract class Node implements Comparable<Node> {
    private String name;

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

    @Override
    public int compareTo(Node other) {
        if (this.name == null || other.name == null) {
            throw new IllegalArgumentException("wrong");
        }
        return this.name.compareTo(other.name);
    }

}
