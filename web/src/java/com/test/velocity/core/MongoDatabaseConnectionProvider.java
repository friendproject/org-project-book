package com.test.velocity.core;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Ankur on 11-10-2015.
 */
public class MongoDatabaseConnectionProvider {

    private static MongoDatabase databaseConnection;

    static {
        System.out.println("Inside Data base connectioon");
        MongoClient mongoClient = new MongoClient();
        databaseConnection = mongoClient.getDatabase("test");
    }

    public static MongoDatabase getDatabaseConnection(){
        return databaseConnection;
    }
}
