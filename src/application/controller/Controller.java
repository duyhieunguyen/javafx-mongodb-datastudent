package application.controller;

import java.awt.print.Book;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import application.model.Student;
import application.service.StudentService;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable {

	private StudentService studentService = new StudentService();

	public List<Student> listStudent = studentService.getAllStudent();

	private String id;

	@FXML
	private TableView<Student> tableView;

	@FXML
	private TableColumn<Student, String> maSV;

	@FXML
	private TableColumn<Student, String> hoTen;

	@FXML
	private TableColumn<Student, String> namSinh;

	@FXML
	private TextField txtMaSV;

	@FXML
	private TextField txtHoTen;

	@FXML
	private TextField txtNamSinh;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadTable();
	}

	@FXML
	private void btnThem() {

		Student sv = new Student();
		sv.setMaSV(txtMaSV.getText());
		sv.setHoTen(txtHoTen.getText());
		sv.setNamSinh(txtNamSinh.getText());

		listStudent.add(sv);
		studentService.insertStudent(sv);
		
		

		loadTable();
		JOptionPane.showMessageDialog(null, "Thêm thành công !!!");

	}
	
	@FXML
	private void btnLuu() {

		Student sv = new Student();
		sv.setMaSV(txtMaSV.getText());
		sv.setHoTen(txtHoTen.getText());
		sv.setNamSinh(txtNamSinh.getText());

		listStudent.add(sv);
		studentService.insertStudent(sv);

		loadTable();
		JOptionPane.showMessageDialog(null, "Lưu thành công !!!");

	}

	@FXML
	public void btnSua() {

		Student sv = new Student(txtMaSV.getText(), txtHoTen.getText(), txtNamSinh.getText());

		int index = -1;
		for (Student s : listStudent) {
			if (s.getMaSV().equals(id)) {
				index = listStudent.indexOf(s);
			}
		}
		if (index != -1) {
			listStudent.remove(index);
			listStudent.add(sv);

		}
		studentService.updateStudent(sv, id);

		loadTable();
		JOptionPane.showMessageDialog(null, "Sửa thành công !!!");

	}

	@FXML
	public void btnXoa() {

		int input = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa không?", "Xóa", JOptionPane.YES_NO_OPTION);
		if (input == 0) {
			int index = -1;
			for (Student s : listStudent) {
				if (s.getMaSV().equals(txtMaSV.getText())) {
					index = listStudent.indexOf(s);
				}
			}
			if (index != -1) {
				listStudent.remove(index);
			}
			studentService.deleteStudent(txtMaSV.getText());
			loadTable();
		}

	}
	
	@FXML
	public void btnTaoMoi() {
		txtMaSV.setDisable(false);
		txtMaSV.setText("");
		txtHoTen.setText("");
		txtNamSinh.setText("");
	}
	
	@FXML
	public void showTable() {

		txtMaSV.setDisable(true);
		Student sv = tableView.getSelectionModel().getSelectedItem();

		id = sv.getMaSV();
		txtMaSV.setText(sv.getMaSV());
		txtHoTen.setText(sv.getHoTen());
		txtNamSinh.setText(sv.getNamSinh());

	}
	
	public void loadTable() {

		maSV.setCellValueFactory(new PropertyValueFactory<Student, String>("maSV"));
		hoTen.setCellValueFactory(new PropertyValueFactory<Student, String>("hoTen"));


		namSinh.setCellValueFactory(new PropertyValueFactory<Student, String>("namSinh"));

		ObservableList<Student> students = FXCollections.observableArrayList(listStudent);
		tableView.setItems(students);

	}
	
	@FXML 
	public void btnThoat() {
		Platform.exit();
	}
	
	
	

}
