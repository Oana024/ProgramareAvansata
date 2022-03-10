package lab2;

public class Problem {
    private Event[] events;
    private Room[] rooms;

    public Problem() {
    }

    public Problem(Event[] events, Room[] rooms) {
        this.events = events;
        this.rooms = rooms;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event... events) {
        this.events = events;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void setRooms(Room... rooms) {
        this.rooms = rooms;
    }
}
