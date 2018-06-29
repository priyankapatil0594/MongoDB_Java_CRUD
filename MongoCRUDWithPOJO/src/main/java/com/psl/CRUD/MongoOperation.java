package com.psl.CRUD;

import com.mongodb.BasicDBObject;
import com.mongodb.Cursor;
import com.mongodb.DBCollection;

public class MongoOperation {

	
	public void retrieveDocuments(DBCollection collection)
	{
		Cursor cursor=collection.find();

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	
	public void retriveOne(DBCollection collection)
	{
		Cursor cursor=collection.find();

		while (cursor.hasNext()) {
			System.out.println(cursor.next().get("name"));
		}
	}
	
	public void updateDocument(DBCollection collection)
	{
		BasicDBObject updated=new BasicDBObject().append("$set",new BasicDBObject().append("name", "priyanka"));
		BasicDBObject old=new BasicDBObject().append("name","rajesh");
		collection.update(old, updated,false,false);
	}

	public void deleteDocument(DBCollection collection,BasicDBObject basicDBObject1) {
	
		collection.remove(basicDBObject1);
	}
}
