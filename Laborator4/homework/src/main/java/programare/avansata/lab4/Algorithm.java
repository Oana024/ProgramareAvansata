package programare.avansata.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Algorithm {

    public Algorithm() {
    }

    int Find(int node, int[] father) {
        int rad, aux;
        rad = node;
        while (father[rad] != 0)
            rad = father[rad];

        while (node != rad) {
            aux = father[node];
            father[node] = rad;
            node = aux;
        }

        return rad;
    }

    void Kruskal(List<Street> streets, int numberOfNodes) {
        int[] father = new int[numberOfNodes + 1];
        List<Street> solution = new ArrayList<>();

        for (int i = 0; i < numberOfNodes; i++)
            father[i] = 0;

        int parentNode1, parentNode2, cost = 0, added = 0;
        for (Street s : streets) {
            parentNode1 = Find(s.getNode1().getIndex(), father);
            parentNode2 = Find(s.getNode2().getIndex(), father);

            if (parentNode1 != parentNode2 && added < numberOfNodes - 1) {
                solution.add(s);
                cost += s.getLength();
                father[parentNode2] = parentNode1;
                added ++;
            }
        }

        System.out.println("Costul minim este " + cost + '\n' + "Strazile sunt: ");
        for(Street s : solution)
            System.out.println(s);
    }
}
