package lab2;

public class Main {

    public static void main(String[] args) {

        Event C1 = new Event();
        C1.setName("C1");
        C1.setNumberOfParticipants(100);
        C1.setStartTime(8);
        C1.setStartTime(10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);
        System.out.println(C1);
        System.out.println(C2);
        System.out.println(L1);
        System.out.println(L2);
        System.out.println(L3);

        Room R1 = new Room();
        R1.setName("401");
        R1.setType(Room.RoomType.COMPUTER_LAB);
        R1.setCapacity(30);
        Room R2 = new Room("403", Room.RoomType.COMPUTER_LAB, 30);
        Room R3 = new Room("405", Room.RoomType.COMPUTER_LAB, 30);
        Room R4 = new Room("309", Room.RoomType.LECTURE_HALL, 100);

        System.out.println(R1);
        System.out.println(R2);
        System.out.println(R3);
        System.out.println(R4);
    }
}
