package com.psl;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.psl.CRUD.MongoOperation;

public class MongoJava {

	public static void main(String[] args) throws UnknownHostException {

		//connected to Mongo Server
		MongoClient client=new MongoClient("localhost",27017);
		System.out.println("connected to server");

		client.getDB("employeedb").dropDatabase();
		//Connected to database
		DB db = client.getDB("employeedb");
		System.out.println("connected to server....   "+db.getName());

		//create collection
		DBCollection collection=db.getCollection("employee");
		System.out.println("Collection created....");
		
		
		BasicDBObject basicDBObject=new BasicDBObject("name","rajesh")
		.append("location","nashik");
		collection.insert(basicDBObject);

 
		BasicDBObject basicDBObject1=new BasicDBObject("name","amar")
		.append("location","Pune");
		collection.insert(basicDBObject1);


		BasicDBObject basicDBObject2=new BasicDBObject("name","rahul")
		.append("location","nagar");
		collection.insert(basicDBObject2);
		
	
		
		MongoOperation operation=new MongoOperation();
		
		System.out.println("---------Retrieve all documents-------------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);
		
		System.out.println("---------Retrieve particular-------------");
		System.out.println("--------------------------------------------");
		operation.retriveOne(collection);
		
		operation.updateDocument(collection);
		System.out.println("---------After updation--------------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);
		 
		operation.deleteDocument(collection,basicDBObject1);
		System.out.println("---------After deletion----------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);


	}

}
