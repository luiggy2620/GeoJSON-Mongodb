package org.example;

import org.example.database.Connection;

public class App {
    public static void main(String[] args) {
        System.out.println(Connection.getConnection().getMongodb());
    }
}