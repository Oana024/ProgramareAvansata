package lab2;

public class Room {
    public enum RoomType {
        LECTURE_HALL,
        COMPUTER_LAB
    }

    private String name;
    private RoomType type;
    private int capacity;

    public Room() { }

    public Room(String name, RoomType type, int capacity){
        this.name = name;
        this.type = type;
        this.capacity = capacity;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("wrong");
        }
        this.name = name;
    }

    public void setType(RoomType type) {
        if(type == null){
            throw new IllegalArgumentException("wrong");
        }
        this.type = type;
    }

    public void setCapacity(int capacity) {
        if(capacity <= 0){
            throw new IllegalArgumentException("wrong");
        }
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public RoomType getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
