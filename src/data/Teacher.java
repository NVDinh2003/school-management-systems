package data;

public class Teacher extends Person {
	private String maGiaoVien, phone, khoa;
	private String luong;

	

	public Teacher(StringBuilder fullName, String gioiTinh, String ngaySinh, String diaChi, String maGiaoVien,
			String phone, String khoa, String luong) {
		super(fullName, gioiTinh, ngaySinh, diaChi);
		this.maGiaoVien = maGiaoVien;
		this.phone = phone;
		this.khoa = khoa;
		this.luong = luong;
	}

	public String getEmail() {
		return phone;
	}

	public void setEmail(String phone) {
		this.phone = phone;
	}

	public String getKhoa() {
		return khoa;
	}

	public void setKhoa(String khoa) {
		this.khoa = khoa;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

	public String getMaGiaoVien() {
		return maGiaoVien;
	}

	@Override
	public void inputInfo() {
		// TODO Auto-generated method stub
		this.maGiaoVien = ck.inputString("Nhập mã giáo viên: ");
		super.inputInfo();
		this.phone = ck.phoneEx();
		this.khoa = ck.inputString("Thuộc khoa: ");
		this.luong = ck.intputMoney("Nhập lương: ");
	}

	@Override
	public void showInfo() {
		// TODO Auto-generated method stub
		System.out.printf("| %-11s", this.maGiaoVien);
		super.showInfo();
		System.out.printf(" %-12s| %-20s| %-10s", this.phone, this.khoa, this.luong);
	}

}
