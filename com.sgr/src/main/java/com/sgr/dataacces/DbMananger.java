package com.sgr.dataacces;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class DbMananger {

	private static String SERVER = "localhost";
	private static String PORT = "27017";
	private static String DATABASE = "eMFlores";
	private static String USER = "therealadmin";
	private static String PASS = "thisistherealadmin";

	public MongoDatabase getDB() {
		MongoClient mongo = new MongoClient(new MongoClientURI("mongodb://" + USER + ":" + PASS + "@" + SERVER + ":" + PORT + "/" + DATABASE ));
		MongoDatabase db = mongo.getDatabase(DATABASE);
		return db;
	}

	public MongoCollection getCollection(String collection) {
		MongoDatabase db = getDB();
		MongoCollection c = db.getCollection(collection);
		return c;
	}
	

}
