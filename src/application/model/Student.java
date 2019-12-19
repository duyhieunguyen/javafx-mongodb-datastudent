package application.model;

public class Student {
	private String maSV;
	private String hoTen;
	private String namSinh;

	public Student(String maSV, String hoTen, String namSinh) {
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
	}

	public Student() {
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(String namSinh) {
		this.namSinh = namSinh;
	}

	@Override
	public String toString() {
		return "Student [maSV=" + maSV + ", hoTen=" + hoTen + ", namSinh=" + namSinh + "]";
	}

}
