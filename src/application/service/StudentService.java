package application.service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.google.gson.Gson;
import com.mongodb.client.model.Filters;

import application.configuration.ConnectMongoDB;
import application.model.Student;

public class StudentService {

	ConnectMongoDB con = new ConnectMongoDB();
	Gson g = new Gson();

	
	public void insertStudent(Student student) {

		Document doc = new Document();
		doc = Document.parse(g.toJson(student));
		con.collection.insertOne(doc);
	}

	public void updateStudent(Student student, String id) {
		Document doc = new Document();
		doc = Document.parse(g.toJson(student));
		Bson filter = Filters.eq("maSV", id);
		con.collection.replaceOne(filter, doc);

	}

	public void deleteStudent(String maSV) {
		Bson filter = Filters.eq("maSV", maSV);
		con.collection.deleteOne(filter);
	}

	public List<Student> getAllStudent() {
		List<Student> listStudent = new ArrayList<Student>();
		for (Document doc : con.findIterable) {
			Student sv = g.fromJson(doc.toJson().toString(), Student.class);
			listStudent.add(sv);
		}
		return listStudent;
	}
}
