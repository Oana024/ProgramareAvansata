package lab2;

public class GreedyAlgorithm extends Algorithm {
    public GreedyAlgorithm() {
    }

    public GreedyAlgorithm(Problem problem) {
        super(problem);
    }

    @Override
    public Solution solve() {
        Solution sol = new Solution();
        Problem problem = super.problem;
        Room[] rooms = problem.getRooms();
        Event[] events = problem.getEvents();

        //sortarea evenimentelor crescator dupa ora la care se termina
        for (int i = 0; i < events.length; i++)
            for (int j = i + 1; j < events.length; j++)
                if (events[i].getEndTime() > events[j].getEndTime()) {
                    Event aux = events[i];
                    events[i] = events[j];
                    events[j] = aux;
                }

        //sortarea salilor crescator dupa capacitate
        for (int i = 0; i < rooms.length; i++)
            for (int j = i + 1; j < rooms.length; j++)
                if (rooms[i].getCapacity() > rooms[j].getCapacity()) {
                    Room aux = rooms[i];
                    rooms[i] = rooms[j];
                    rooms[j] = aux;
                }

        int[] used = new int[rooms.length]; //used[i] -> de cate ori a fost folosita sala cu indexul i

        for (int i = 0; i < rooms.length; i++)
            used[i] = 0;

        Room[] usedRooms = new Room[events.length]; //usedRoom[i] -> evenimentul i foloseste sala usedRoom[i]

        int hourInterval = 1;

        for (int i = 0; i < events.length; i++) {
            if (i > 0 && events[i].getEndTime() != events[i - 1].getEndTime()) //cand trec la alt interval orar pot folosi sali care s-au eliberat
                hourInterval++;

            for (int j = 0; j < rooms.length; j++) //pentru fiecare eveniment caut prima sala care are capacitate suficienta si este neocupata la acel interval orar
                if (events[i].getNumberOfParticipants() <= rooms[j].getCapacity() && used[j] != hourInterval && usedRooms[i] == null) {
                    used[j] = hourInterval;
                    usedRooms[i] = rooms[j];
                }
        }

        sol.assignRooms(usedRooms);
        sol.assignEvents(events);

        return sol;
    }
}
