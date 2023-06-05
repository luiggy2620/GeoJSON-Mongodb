package org.example.controller;

import org.example.database.Mapboxdb;
import org.example.database.TemporalData;
import org.example.model.GeoJSON;
import org.example.view.Logs;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    private Logs logs;
    private TemporalData data;
    private Mapboxdb mapboxdb;
    private Scanner scanner;
    private boolean isRunning;

    public Application() {
        this.isRunning = true;
        this.logs = new Logs();
        this.data = new TemporalData();
        this.scanner = new Scanner(System.in);
        this.mapboxdb = Mapboxdb.getMapboxdb();
    }

    public void start() {
        mapboxdb.initDatabase();
        while (isRunning) {
            logs.showIndicator();
            if (scanner.nextLine().equals("post")) postLocations();
            else getLocations();
        }
    }

    private void getLocations() {
        logs.showGeoJSON(mapboxdb.getLocations());
    }

    private void postLocations() {
        logs.showIndicator();
        ArrayList<GeoJSON> amountData = data.getData(scanner.nextInt());
        long startTime = System.currentTimeMillis();
        amountData.forEach(geoJSON -> {
            mapboxdb.postLocation(geoJSON);
        });
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Time to read " + amountData.size() + " documents: " + totalTime + " milliseconds. - " + (totalTime / 1000.0) + " seconds.");
    }
}