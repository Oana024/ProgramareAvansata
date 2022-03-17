package lab3;

public class Router extends Node implements Identifiable {
    private String address;

    public Router(){

    }

    public Router(String name, String address) {
        super(name);
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getAddress() {
        return this.address;
    }

    @Override
    public String getType() {
        return "Router";
    }
}
