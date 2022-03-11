package lab3;

public class Main {

    public static void main(String[] args) {
        Node n1 = new Computer("Computer A", "1.2.3.4.5", 128);
        Node n2 = new Router("Router A", "0.1.2.3");
        Node n3 = new Switch("Switch A");
        Node n4 = new Computer("Computer B", "10.11.12.13", 512);
        Node n5 = new Switch("Switch B");
        Node n6 = new Router("Router B", "9.8.6.7");

        Network network = new Network();
        network.addNode(n1);
        network.addNode(n2);
        network.addNode(n3);
        network.addNode(n4);
        network.addNode(n5);
        network.addNode(n6);

        System.out.println(network);
    }
}
