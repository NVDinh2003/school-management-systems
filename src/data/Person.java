package data;

import util.CheckInput;

public class Person {
	CheckInput ck = new CheckInput();

	protected StringBuilder fullName;
	protected String gioiTinh, ngaySinh, diaChi;

	

	public Person() {
	}

	public Person(StringBuilder fullName, String gioiTinh, String ngaySinh, String diaChi) {
		super();
		this.fullName = fullName;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}

	public StringBuilder getName() {
		return fullName;
	}

	public void setName(StringBuilder fullName) {
		this.fullName = fullName;
	}

	public String getLastName() {
		String lastName = this.fullName.toString();
		return lastName.split(" ")[lastName.split(" ").length - 1];
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public void inputInfo() {
		this.fullName = ck.fullNameEx("Input full name: ");
		this.ngaySinh = ck.dateEx("Nhập ngày sinh: ");
		this.gioiTinh = ck.gioiTinh();
		this.diaChi = ck.address();
	}

	public void showInfo() {
		System.out.printf("| %-20s| %-11s| %-4s| %-20s|", this.fullName, this.ngaySinh, this.gioiTinh, this.diaChi);
	}
}
