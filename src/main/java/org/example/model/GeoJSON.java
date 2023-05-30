package org.example.model;

public class GeoJSON {

    private String type;
    private Geometry geometry;
    private Properties properties;

    public GeoJSON(String type, Geometry geometry, Properties properties) {
        this.type = type;
        this.geometry = geometry;
        this.properties = properties;
    }

    public String getType() {
        return type;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public Properties getProperties() {
        return properties;
    }
}