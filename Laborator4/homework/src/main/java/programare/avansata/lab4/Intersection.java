package programare.avansata.lab4;

import java.util.Objects;

public class Intersection {
    private String name;
    private int numberOfStreets;
    private int index;

    public Intersection(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfStreets(int numberOfStreets) {
        this.numberOfStreets = numberOfStreets;
    }

    public int getNumberOfStreets() {
        return numberOfStreets;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "Intersection{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intersection that = (Intersection) o;
        return Objects.equals(name, that.name);
    }
}

