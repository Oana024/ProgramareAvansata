package lab3;

public class Switch extends Node {
    public Switch() {

    }

    public Switch(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "Switch";
    }

}
