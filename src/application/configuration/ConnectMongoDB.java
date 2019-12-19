package application.configuration;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ConnectMongoDB {
	MongoClient mongoClient = new MongoClient("localhost:27017");
	MongoDatabase database = mongoClient.getDatabase("datastudent");
	public MongoCollection<Document> collection = database.getCollection("Student");
	public FindIterable<Document> findIterable = collection.find(new Document());
}
