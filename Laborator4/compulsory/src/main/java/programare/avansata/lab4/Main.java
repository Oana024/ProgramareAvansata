package programare.avansata.lab4;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection("v" + i)).toArray(Intersection[]::new);

        List<Intersection> nodeList = new ArrayList<>();
        nodeList.addAll(Arrays.asList(nodes));

        Collections.sort(nodeList, ((u, v) -> u.getName().compareTo(v.getName())));

        for(Intersection i : nodeList)
            System.out.println(i);

        List<Street> streets = new LinkedList<>();

        streets.add(new Street("s1", 2, nodeList.get(0), nodeList.get(3)));
        streets.add(new Street("s2", 2, nodeList.get(0), nodeList.get(2)));
        streets.add(new Street("s3", 2, nodeList.get(0), nodeList.get(1)));

        streets.add(new Street("s4", 1, nodeList.get(1), nodeList.get(2)));
        streets.add(new Street("s5", 3, nodeList.get(1), nodeList.get(4)));

        streets.add(new Street("s6", 2, nodeList.get(2), nodeList.get(3)));
        streets.add(new Street("s7", 2, nodeList.get(2), nodeList.get(4)));
        streets.add(new Street("s8", 2, nodeList.get(2), nodeList.get(6)));

        streets.add(new Street("s9", 3, nodeList.get(3), nodeList.get(8)));

        streets.add(new Street("s10", 3, nodeList.get(4), nodeList.get(5)));
        streets.add(new Street("s11", 1, nodeList.get(4), nodeList.get(8)));

        streets.add(new Street("s12", 1, nodeList.get(5), nodeList.get(5)));
        streets.add(new Street("s13", 1, nodeList.get(5), nodeList.get(7)));
        streets.add(new Street("s14", 2, nodeList.get(5), nodeList.get(8)));

        streets.add(new Street("s15", 1, nodeList.get(6), nodeList.get(7)));

        streets.add(new Street("s16", 2, nodeList.get(7), nodeList.get(8)));

        Collections.sort(streets);

        for(Street s : streets)
            System.out.println(s);

        Map <Intersection, List<Street>> city = new HashMap<>();

        for(Intersection i : nodeList) {
            List<Street> streetList = new ArrayList<>();
            for(Street s : streets)
                if(s.getNode1() == i || s.getNode2() == i)
                    streetList.add(s);
            city.put(i, streetList);
        }

        for(Intersection i : city.keySet())
            System.out.println(i + " " + city.get(i));
    }
}
