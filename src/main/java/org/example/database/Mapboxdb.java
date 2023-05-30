package org.example.database;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.example.model.GeoJSON;

public class Mapboxdb {

    protected MongoDatabase database;
    private MongoClient connection;
    MongoCursor<Document> locations;
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

    public void initDatabase() {
        getLocationsCollection();
    }

    public MongoCursor<Document> getLocations() {
        try {
            locations = getLocationsCollection().find().iterator();
        } catch (MongoException exception) {
            System.out.println(exception);
        }
        return locations;
    }

    public void postLocation(GeoJSON geoJSON) {
        try {
            getLocationsCollection().insertOne(getLocationDocumentation(geoJSON));
        } catch (MongoException exception) {
            System.out.println(exception);
        }
    }

    public Document getLocationDocumentation(GeoJSON geoJSON) {
        return new Document()
                .append("_id", new ObjectId())

                .append("type", geoJSON.getType())
                .append("geometry", new Document()
                        .append("type", geoJSON.getGeometry().getType())
                        .append("coordinates", geoJSON.getGeometry().getCoordinates()))

                .append("properties", new Document()
                        .append("name", geoJSON.getProperties().getName())
                        .append("country", geoJSON.getProperties().getCountry()));
    }
}