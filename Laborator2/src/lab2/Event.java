package lab2;

public class Event {
    private String name;
    private int numberOfParticipants;
    private int startTime;
    private int endTime;

    public Event(){ }

    public Event(String name, int numberOfParticipants, int startTime, int endTime){
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("wrong");
        }
        this.name = name;
    }

    public void setNumberOfParticipants(int numberOfParticipants) {
        if(numberOfParticipants <= 0){
            throw new IllegalArgumentException("wrong");
        }
        this.numberOfParticipants = numberOfParticipants;
    }

    public void setStartTime(int startTime) {
        if(startTime < 0){
            throw new IllegalArgumentException("wrong");
        }
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        if(endTime < 0 || endTime < this.startTime){
            throw new IllegalArgumentException("wrong");
        }
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", numberOfParticipants=" + numberOfParticipants +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
