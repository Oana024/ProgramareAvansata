package lab2;

public class Main {

    public static void main(String[] args) {
        Event C1 = new Event("C1", 100, 8, 10);
        Event C2 = new Event("C2", 100, 10, 12);
        Event L1 = new Event("L1", 30, 8, 10);
        Event L2 = new Event("L2", 30, 8, 10);
        Event L3 = new Event("L3", 30, 10, 12);

        Room R1 = new ComputerLab("401", 30, "Windows 11");
        Room R2 = new ComputerLab("403", 30, "Windows 10");
        Room R3 = new ComputerLab("405", 30, "Linux");
        Room R4 = new LectureHall("309", 100, true);

        Problem pb = new Problem();
        pb.setRooms(R1, R2, R3, R4);
        pb.setEvents(C1, C2, L1, L2, L3);
        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution sol = greedy.solve();
        sol.print();
    }
}
