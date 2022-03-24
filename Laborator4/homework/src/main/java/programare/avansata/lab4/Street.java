package programare.avansata.lab4;

import java.util.Collections;

public class Street implements Comparable<Street>{
    private String name;
    private int length;
    Intersection node1;
    Intersection node2;

    public Street(String name, int length, Intersection node1, Intersection node2) {
        this.name = name;
        this.length = length;
        this.node1 = node1;
        this.node2 = node2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setNode1(Intersection node1) {
        this.node1 = node1;
    }

    public void setNode2(Intersection node2) {
        this.node2 = node2;
    }

    Boolean VerifyCount(Street street) {
        Intersection i1 = street.getNode1();
        Intersection i2 = street.getNode2();
        if(i1.getNumberOfStreets() > 3 || i2.getNumberOfStreets() > 3)
            return true;
        return false;
    }

    public Intersection getNode1() {
        return node1;
    }

    public Intersection getNode2() {
        return node2;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", node1=" + node1 +
                ", node2=" + node2 +
                '}';
    }

    @Override
    public int compareTo(Street o) {
        return Integer.compare(this.length, o.getLength());
    }
}
