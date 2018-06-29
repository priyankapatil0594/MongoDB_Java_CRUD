package com.psl;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
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
		
		
		Employee employee=new Employee(1,"mayuri","Pune");
		Employee employee2=new Employee(2,"manisha","Pune");
		DBObject object=createDBobject(employee2);
		collection.insert(object);
		
		//Method1
		/*Gson gson = new Gson();
		String json = gson.toJson(employee);    
		BasicDBObject basicDBObject = new BasicDBObject("Name", json );          
		collection.save(basicDBObject);  */
		 
		 MongoCollection<Employee> studCollection=db.getCollection("student",Employee.class);
	
		MongoOperation operation=new MongoOperation();
		
		System.out.println("---------Retrieve all documents-------------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);
		
		/*System.out.println("---------Retrieve particular-------------");
		System.out.println("--------------------------------------------");
		operation.retriveOne(collection);
		
		operation.updateDocument(collection);
		System.out.println("---------After updation--------------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);
		*/
		/* 
		operation.deleteDocument(collection,basicDBObject1);
		System.out.println("---------After deletion----------");
		System.out.println("--------------------------------------------");
		operation.retrieveDocuments(collection);
*/

	}

	private static DBObject createDBobject(Employee e) {
		BasicDBObjectBuilder builder=BasicDBObjectBuilder.start();
		builder.append("id",e.getEmpId());
		builder.append("name", e.getName());
		builder.append("location",e.getLocation());
		return builder.get();
	}

}
