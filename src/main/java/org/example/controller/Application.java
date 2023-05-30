package org.example.controller;

import org.example.database.Mapboxdb;
import org.example.database.TemporalData;
import org.example.view.Logs;

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
        data.getData().forEach(geoJSON -> {
            mapboxdb.postLocation(geoJSON);
        });
    }
}