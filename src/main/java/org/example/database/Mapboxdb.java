package org.example.database;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Mapboxdb {

    protected MongoDatabase database;
    private MongoClient connection;
    protected MongoCollection<Document> locationsCollection;
    private static Mapboxdb mapboxdb;

    public static Mapboxdb getMapboxdb() {
        if (mapboxdb == null)
            mapboxdb = new Mapboxdb();

        return mapboxdb;
    }

    private MongoClient getConnection() {
        if (connection == null)
            connection = Connection.getConnection().getDatabase();
        return connection;
    }

    private MongoDatabase getDatabase() {
        if (database == null)
            database = getConnection().getDatabase("mapbox");
        return database;
    }

    private MongoCollection<Document> getLocationsCollection() {
        if (locationsCollection == null)
            locationsCollection = getDatabase().getCollection("locations");
        return locationsCollection;
    }

}