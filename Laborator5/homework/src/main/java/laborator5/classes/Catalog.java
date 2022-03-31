package laborator5.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Catalog {
    private String name;
    private List<Item> items = new ArrayList<>();

    public Catalog() {

    }

    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void add(Item item) {
        items.add(item);
    }

    public Item findById(String id) {
        for (Item i : items)
            if (Objects.equals(i.getId(), id)) {
                System.out.println(i);
                return i;
            }
        return null;
    }

    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", items=" + items +
                '}';
    }
}
