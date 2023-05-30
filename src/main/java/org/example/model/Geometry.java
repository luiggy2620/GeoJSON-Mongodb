package org.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Geometry {

    private String type;
    private ArrayList<Double[]> coordinates;

    public Geometry(String type, Double[]... newCoordinates) {
        this.type = type;
        this.coordinates = new ArrayList<>(List.of(newCoordinates));
    }

    public void addCoordinates(Double[]... newCoordinates) {
        this.coordinates.addAll(List.of(newCoordinates));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<ArrayList<Double>> getCoordinates() {
        ArrayList<ArrayList<Double>> coordinatesList = new ArrayList<>();

        for (Double[] coordinateArray : coordinates) {
            ArrayList<Double> coordinateList = new ArrayList<>(Arrays.asList(coordinateArray));
            coordinatesList.add(coordinateList);
        }

        return coordinatesList;
    }
}