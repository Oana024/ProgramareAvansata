package programare.avansata.lab4;

import java.util.*;

public class City {
    Map<Intersection, List<Street>> cityMap = new HashMap<>();

    public City() {

    }

    public City(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public void setCity(Map<Intersection, List<Street>> cityMap) {
        this.cityMap = cityMap;
    }

    public Map<Intersection, List<Street>> getCity() {
        return cityMap;
    }

    void Print() {
        for (Intersection i : cityMap.keySet()) {
            System.out.println(i + " -> " + i.getIndex());
            for (Street s : cityMap.get(i))
                System.out.println(s);
            System.out.println("-------------------------");
        }

    }

    void Filter(int length) {
        for (Intersection i : cityMap.keySet())
            cityMap.get(i).stream().filter(v -> v.getLength() > length && v.VerifyCount(v)).forEach(System.out::println);
    }
}
