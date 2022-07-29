package data;

public class Student extends Person {
	private String maSinhVien, email;
	private double GPA;

	public Student() {
	}

	public Student(StringBuilder fullName, String gioiTinh, String ngaySinh, String diaChi, String maSinhVien,
		String email, double GPA) {
		super(fullName, gioiTinh, ngaySinh, diaChi);
		this.maSinhVien = maSinhVien;
		this.email = email;
		this.GPA = GPA;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getGPA() {
		return GPA;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public String getMaSinhVien() {
		return maSinhVien;
	}

	public boolean checkStudentGrant() {
		if (this.GPA > 8)
			return true;
		else
			return false;
	}

	@Override
	public void inputInfo() {
		// TODO Auto-generated method stub
		this.maSinhVien = ck.inputString("Nhập mã sinh viên: ");
		super.inputInfo();
		this.email = ck.emailEx();
		this.GPA = ck.inputDouble("Nhập GPA: ", "Lỗi ! ( điểm TB < 0 và điểm TB > 10)", 0, 10);
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.printf("| %-11s", this.maSinhVien);
		super.showInfo();
		System.out.printf(" %-25s| %-2.1f", this.email, this.GPA);
	}

	@Override
	public String toString() {
		return "Student [maSinhVien=" + maSinhVien + ", email=" + email + ", diemTB=" + GPA + ", fullName="
				+ fullName + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + "]";
	}

	
}
