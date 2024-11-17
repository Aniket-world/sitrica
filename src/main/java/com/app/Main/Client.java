package com.app.Main;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

import javafx.scene.chart.PieChart.Data;

public class Client {
    private String name;
    private String email;
    private String password;
    private double rating;
    private static MongoClient mongoClient;

    public static void main(String[] args) {
        connect();
    }

    private static void connect() {
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("test");
        System.out.println("Connected to the database");
    }
}
