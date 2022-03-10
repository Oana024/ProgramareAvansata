package lab2;

public class ComputerLab extends Room {
    private String operatingSystem;

    public ComputerLab() {
    }

    public ComputerLab(String name, int capacity, String operatingSystem) {
        super(name, capacity);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Override
    public String toString() {
        return "ComputerLab{" +
                "operatingSystem='" + operatingSystem + '\'' +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
