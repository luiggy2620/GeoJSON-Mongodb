package org.example.database;

import org.example.model.GeoJSON;
import org.example.model.Geometry;
import org.example.model.Properties;

import java.util.ArrayList;

public class TemporalData {

    public ArrayList<GeoJSON> getData(int amountData) {
        return generateData(amountData);
    }

    private ArrayList<GeoJSON> generateData(int amountData) {
        ArrayList<GeoJSON> data = new ArrayList<>();
        for (int i = 0; i < amountData; i++) {
            data.add(new GeoJSON(
                    "Feature",
                    new Geometry("Polygon", new Double[]{-122.4086, 37.7837}, new Double[]{-122.4200, 37.7891},
                            new Double[]{-122.4156, 37.7916}, new Double[]{-122.4086, 37.7837}),
                    new Properties("Financial District", "United States")));
        }

        return data;
    }

}