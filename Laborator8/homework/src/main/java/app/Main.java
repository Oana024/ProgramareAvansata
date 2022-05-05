package app;

import classes.Tools.DistanceCalculator;
import classes.Tools.WordCapitals;

public class Main {
    public static void main(String args[]) {

        WordCapitals wordCapitals = new WordCapitals();
        wordCapitals.add();

        DistanceCalculator distanceCalculator = new DistanceCalculator();

        distanceCalculator.Calculate(1, 2);
        distanceCalculator.Calculate(7, 10);
        distanceCalculator.Calculate(21, 44);
        distanceCalculator.Calculate(4, 9);
    }
}