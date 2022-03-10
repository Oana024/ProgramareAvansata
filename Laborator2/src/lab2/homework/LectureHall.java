package lab2;

public class LectureHall extends Room {
    private Boolean projector;

    public LectureHall() {
    }

    public LectureHall(String name, int capacity, Boolean projector) {
        super(name, capacity);
        this.projector = projector;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

    @Override
    public String toString() {
        return "LectureHall{" +
                "projector=" + projector +
                ", name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
