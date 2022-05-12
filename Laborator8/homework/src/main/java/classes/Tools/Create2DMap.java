package classes.Tools;

import classes.Object.City;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Create2DMap extends JFrame {
    private List<City> cities = new ArrayList<>();
    private int sizeX = 800, sizeY = 800;

    public Create2DMap(List<City> cities) {
        this.cities.addAll(cities);
        setTitle("Drawing Cities");
        setSize(sizeX, sizeY);
        setVisible(true);
        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private int getLatitude(Float latitude) {
        Float newLatitude = 0f;

        newLatitude = latitude + (float) 20037508.34;
        newLatitude = newLatitude * sizeY / ((float) 20037508.34 * 2);

        return newLatitude.intValue();
    }

    private int getLongitude(Float longitude) {
        Float newLongitude = 0f;

        newLongitude = longitude + (float) 23810769.32;
        newLongitude = newLongitude * sizeX / ((float) 23810769.32 * 2);

        return newLongitude.intValue();
    }

    double xAxisProjection(double input) {
        return Math.toRadians(input) * 6378137.0;
    }

    double yAxisProjection(double input) {
        return Math.log(Math.tan(Math.PI / 4 + Math.toRadians(input) / 2)) * 6378137.0;
    }

    @Override
    public void paint(Graphics graphics) {

        graphics.setColor(Color.black);
        graphics.fillRect(0, 0, sizeX, sizeX);

        for (City city : cities) {
            int x = getLongitude((float) xAxisProjection(city.getLongitude()));
            int y = getLatitude((float) yAxisProjection(city.getLatitude()));

            graphics.setColor(Color.white);
            graphics.fillOval(x, y, 4, 4);
        }
    }
}
