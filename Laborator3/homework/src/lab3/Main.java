package lab3;

public class Main {

    public static void main(String[] args) {
        Node v1 = new Computer("Computer A", "1.2.3.4.5", 128);
        Node v2 = new Router("Router A", "0.1.2.3");
        Node v3 = new Switch("Switch A");
        Node v4 = new Switch("Switch B");
        Node v5 = new Router("Router B", "10.11.12.13");
        Node v6 = new Computer("Computer B", "9.8.6.7", 512);

        System.out.println("Capacitatea in megabytes este: " + ((Computer)v1).getStorageCapacity(Storage.storageUnit.megabyte));

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 20);
        v3.setCost(v4, 10);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        Network network = new Network();
        network.addNode(v1);
        network.addNode(v2);
        network.addNode(v3);
        network.addNode(v4);
        network.addNode(v5);
        network.addNode(v6);

        network.printNetwork();

        network.printIdentifiable();

        int[][] adjMat;
        adjMat = network.getAdjacencyMatrix();

        network.FloydWarshall(adjMat);
    }
}
