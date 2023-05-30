package org.example.database;

import org.example.model.GeoJSON;
import org.example.model.Geometry;
import org.example.model.Properties;

import java.util.ArrayList;
import java.util.List;

public class TemporalData {

    private ArrayList<GeoJSON> data;

    public TemporalData() {
        this.data = new ArrayList<>();
    }

    public ArrayList<GeoJSON> getData() {
        if (data.isEmpty())
            data = generateData();

        return data;
    }

    private ArrayList<GeoJSON> generateData() {
        GeoJSON geoJSON1 = new GeoJSON(
                "Feature",
                new Geometry("Point", new Double[]{-122.4194, 37.7749}),
                new Properties("San Francisco", "United States"));

        GeoJSON geoJSON2 = new GeoJSON(
                "Feature",
                new Geometry("LineString", new Double[]{-122.4194, 37.7749}, new Double[]{-122.4086, 37.7837}),
                new Properties("Market Street", "United States"));

        GeoJSON geoJSON3 = new GeoJSON(
                "Feature",
                new Geometry("Polygon", new Double[]{-122.4086, 37.7837}, new Double[]{-122.4200, 37.7891},
                        new Double[]{-122.4156, 37.7916}, new Double[]{-122.4086, 37.7837}),
                new Properties("Financial District", "United States"));

        return new ArrayList<>(List.of(geoJSON1, geoJSON2, geoJSON3));
    }

}