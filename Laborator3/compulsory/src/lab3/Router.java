package lab3;

public class Router extends Node implements Identifiable {
    private String address;

    public Router(String name, String address) {
        super(name);
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }
}
