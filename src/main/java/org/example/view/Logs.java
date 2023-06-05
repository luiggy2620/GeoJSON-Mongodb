package org.example.view;

import com.mongodb.client.MongoCursor;
import org.bson.Document;

public class Logs {

    public void showIndicator() {
        System.out.print(">> ");
    }

    public void showGeoJSON(MongoCursor<Document> locations) {
        locations.forEachRemaining(System.out::println);

    }
}