package lab2;

import java.util.Arrays;

public class Solution {
    private Room[] assignment;
    private Event[] events;

    public int computeUsedRooms() {
        int count = 0;
        boolean unique;
        //verific cate room-uri unice au fost asignate evenimentelor
        for (int i = 0; i < assignment.length; i++) {
            unique = true;
            for (int j = i + 1; j < assignment.length; j++)
                if (assignment[i] == assignment[j]) {
                    unique = false;
                }
            if (unique)
                count++;
        }
        return count;
    }

    public void assignRooms(Room[] rooms) {
        assignment = rooms;
    }

    public void assignEvents(Event[] events) {
        this.events = events;
    }

    public void print() {
        boolean solved = true;
        for (int i = 0; i < events.length && solved; i++)
            if(assignment[i] == null) {
                System.out.println("Nu am reusit sa gasesc o atribuire");
                solved = false;
            }

        if(solved == true)
            for (int i = 0; i < events.length; i++)
                System.out.println(events[i].getName() + " -> " + assignment[i].getName());
    }
}
