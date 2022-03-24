package programare.avansata.lab4;

import com.github.javafaker.Faker;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();

        //se creeaza intersectiile
        var nodes = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new Intersection(faker.funnyName().name(), i + 1)).toArray(Intersection[]::new);

        List<Intersection> nodeList = new ArrayList<>();
        nodeList.addAll(Arrays.asList(nodes));

        Collections.sort(nodeList, ((u, v) -> u.getName().compareTo(v.getName())));

        //se creeaza strazile
        List<Street> streets = new LinkedList<>();

        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(0), nodeList.get(1)));
        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(0), nodeList.get(2)));
        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(0), nodeList.get(3)));

        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(1), nodeList.get(2)));
        streets.add(new Street(faker.address().streetName(), 3, nodeList.get(1), nodeList.get(4)));

        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(2), nodeList.get(3)));
        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(2), nodeList.get(4)));
        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(2), nodeList.get(6)));

        streets.add(new Street(faker.address().streetName(), 3, nodeList.get(3), nodeList.get(8)));

        streets.add(new Street(faker.address().streetName(), 3, nodeList.get(4), nodeList.get(5)));
        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(4), nodeList.get(8)));

        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(5), nodeList.get(6)));
        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(5), nodeList.get(7)));
        streets.add(new Street(faker.address().streetName(), 2, nodeList.get(5), nodeList.get(8)));

        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(6), nodeList.get(7)));

        streets.add(new Street(faker.address().streetName(), 1, nodeList.get(7), nodeList.get(8)));

        Collections.sort(streets);

        Map <Intersection, List<Street>> city = new HashMap<>();
        for(Intersection i : nodeList) {
            List<Street> streetList = new ArrayList<>();
            for(Street s : streets)
                if(s.getNode1() == i || s.getNode2() == i)
                    streetList.add(s);
            city.put(i, streetList);
            i.setNumberOfStreets(streetList.size());
        }

        City City = new City();
        City.setCity(city);

        City.Filter(2);

        Algorithm algorithm = new Algorithm();

        algorithm.Kruskal(streets, city.keySet().size());

    }
}
