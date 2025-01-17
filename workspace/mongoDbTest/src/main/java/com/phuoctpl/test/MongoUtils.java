package com.phuoctpl.test;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

public class MongoUtils {

	private static final String HOST = "localhost";
	private static final int PORT = 27017;

	//
	private static final String USERNAME = "phuoctpl1";
	private static final String PASSWORD = "phuoctpl1";

	private static MongoClient getMongoClient_1() throws UnknownHostException {
		MongoClient mongoClient = new MongoClient(HOST, PORT);
		return mongoClient;
	}

	private static MongoClient getMongoClient_2() throws UnknownHostException {
		MongoCredential credential = MongoCredential.createMongoCRCredential(
				USERNAME, MyConstants.DB_NAME, PASSWORD.toCharArray());

		MongoClient mongoClient = new MongoClient(
				new ServerAddress(HOST, PORT), Arrays.asList(credential));
		return mongoClient;
	}

	public static MongoClient getMongoClient() throws UnknownHostException {

		return getMongoClient_2();
	}

	private static void ping() throws UnknownHostException {
		MongoClient mongoClient = getMongoClient();

		System.out.println("List all DB:");

		List<String> dbNames = mongoClient.getDatabaseNames();
		for (String dbName : dbNames) {
			System.out.println("+ DB Name: " + dbName);
		}

		System.out.println("Done!");
	}

	// Test
	public static void main(String[] args) throws UnknownHostException {
		ping();
	}

}
