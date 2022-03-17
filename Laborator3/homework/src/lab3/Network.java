package lab3;

import java.util.*;

public class Network {
    private List<Node> nodes = new ArrayList<>();
    private List <Node> identifiableNodes = new ArrayList<>();

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

    public void printNetwork() {
        for (Node node : nodes) {
            node.Print();
        }
        System.out.print('\n');
    }

    public void printIdentifiable() {
        //dintre toate nodurile le selectez doar pe cele 'identifiable', adica doar cele de tip computer sau router
        for(Node node : nodes) {
            if(Objects.equals(node.getType(), "Computer") || Objects.equals(node.getType(), "Router")) {
                identifiableNodes.add(node);
            }
        }

        //sortarea listei de noduri identifiable dupa adresa
        String node1, node2;
        for(int i = 0; i < identifiableNodes.size(); i++)
            for(int j = i + 1; j < identifiableNodes.size(); j++) {
                if (Objects.equals(identifiableNodes.get(i).getType(), "Computer")) //node1 este adresa primului nod al comparatiei
                    node1 = ((Computer) identifiableNodes.get(i)).getAddress();
                else
                    node1 = ((Router) identifiableNodes.get(i)).getAddress();

                if (Objects.equals(identifiableNodes.get(j).getType(), "Computer")) //node2 este adresa celui de-al doilea nod al comparatiei
                    node2 = ((Computer) identifiableNodes.get(j)).getAddress();
                else
                    node2 = ((Router) identifiableNodes.get(j)).getAddress();

                if(node1.compareTo(node2) > 0){
                    Node aux = identifiableNodes.get(j);
                    identifiableNodes.set(j, identifiableNodes.get(i));
                    identifiableNodes.set(i, aux);
                }

            }

        //afisez lista sortata
        for(Node node : identifiableNodes) {
            System.out.print(node.getName() + " ");
            if(Objects.equals(node.getType(), "Computer"))
                System.out.print(((Computer)node).getAddress() + "\n");
            else
                System.out.print(((Router)node).getAddress() + "\n");
        }
    }

    public int[][] getAdjacencyMatrix(){ //aflu matricea de adiacenta
        int adjacencyMatrix[][] = new int[identifiableNodes.size()][identifiableNodes.size()];
        Map <Node, Integer> costs = new HashMap<>();

        for(int i = 0; i < identifiableNodes.size(); i++) {
            costs = identifiableNodes.get(i).getCost();
            for (Node node : costs.keySet()) { //pentru fiecare nod din Map, care este vecin al nodului curent caut ce index are nodul pentru a-l adauga in matricea de adiacenta
                for (int j = 0; j < identifiableNodes.size(); j++)
                    if (node == identifiableNodes.get(j)) { //daca nodul din Map se potriveste cu nodul din lista de pe pozitia j atunci nodul i si nodul j sunt adiacente
                        adjacencyMatrix[i][j] = costs.get(node);
                    }
            }
        }
        return adjacencyMatrix;
    }

    public void FloydWarshall(int[][] adjMatrix){
        int n = identifiableNodes.size();

        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(i != j && adjMatrix[i][j] == 0)
                    adjMatrix[i][j] = 1000000;

        for(int k = 0; k < n; k++)
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    if(adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j])
                        adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];

        System.out.print("\n");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++)
                if(adjMatrix[i][j] != 0) {
                    System.out.println(identifiableNodes.get(i).getName() + " -> " + identifiableNodes.get(j).getName() + " cost: " + adjMatrix[i][j]);
                }
        }
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
