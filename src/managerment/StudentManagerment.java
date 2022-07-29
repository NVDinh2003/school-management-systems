package managerment;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import comaprator.MarkComparator;
import comaprator.NameStudentComparator;
import data.Student;
import util.CheckInput;
import util.Menu;

public class StudentManagerment {
	CheckInput ck = new CheckInput();
	private List<Student> listStudent;

	public StudentManagerment() {
		this.listStudent = new LinkedList<Student>();
	}

	public void insertStudent() {
		Student x = new Student();
		x.inputInfo();

		this.listStudent.add(x);
	}

	public void searchStudentByID(String StID) {
		boolean check = false;
		for (Student x : listStudent)
			if (x.getMaSinhVien().equalsIgnoreCase(StID)) {
				check = true;
				showTitle();
				x.showInfo();
				System.out.println();
				break;
			}

		if (!check)
			System.out.println("Không có sinh viên nào có mã là " + StID);
	}

	public void showInforAllStudent() {
		showTitle();
		for (Student x : listStudent) {
			x.showInfo();
			System.out.println();
		}
		System.out.println();
	}

	public void removeAStudentByID(String id) {
		Iterator<Student> itr = listStudent.iterator();
		while (itr.hasNext()) {
			if (itr.next().getMaSinhVien().equalsIgnoreCase(id))
				itr.remove();
		}
	}

	public void updateAStudentByID(String id) {
		boolean check = false;
		for (Student x : listStudent) {
			if (x.getMaSinhVien().equalsIgnoreCase(id)) {
				check = true;
				showTitle();
				x.showInfo();
				System.out.println();
				Menu SMenu = new Menu("Update Student Information !");
				System.out.println("\n-Nhập lựa chọn để cập nhật: ");
				SMenu.addNewOption("1. Họ tên");
				SMenu.addNewOption("2. Ngày sinh");
				SMenu.addNewOption("3. Giới tính");
				SMenu.addNewOption("4. Địa chỉ");
				SMenu.addNewOption("5. Email");
				SMenu.addNewOption("6. GPA");
				SMenu.addNewOption("7. Trở lại");

				int choice;
				do {
					SMenu.printMenu();
					choice = SMenu.getChoice();
					switch (choice) {
					case 1:
						StringBuilder newName = ck.fullNameEx("Nhập tên mới: ");
						x.setName(newName);
						break;
					case 2:
						String date = ck.dateEx("Nhập ngày sinh: ");
						x.setNgaySinh(date);
						break;
					case 3:
						String newGender = ck.gioiTinh();
						x.setGioiTinh(newGender);
						break;
					case 4:
						String newAddress = ck.address();
						x.setDiaChi(newAddress);
						break;
					case 5:
						String newEmail = ck.emailEx();
						x.setEmail(newEmail);
						break;
					case 6:
						double newGPA = ck.inputDouble("Nhập GPA mới: ", "0 <= GPA <= 10", 0, 10);
						x.setGPA(newGPA);
						break;
					case 7:
						break;
					}
				} while (choice != SMenu.getMaxOption());

				break;
			}
		}
		if (!check)
			System.out.println("Không có sinh viên nào có mã là " + id + "\n");
	}

	public void showSMaxMarkAndMinMark() {
		Collections.sort(listStudent, new MarkComparator());
		System.out.println("\t-Sinh viên có điểm trung bình cao nhất:");
		showTitle();
		for (Student x : listStudent)
			if (x.getGPA() < listStudent.get(0).getGPA())
				break;
			else {
				x.showInfo();
				System.out.println();
			}

		System.out.println("\t-Sinh viên có điểm trung bình thấp nhất:");
		showTitle();
		int lasti = listStudent.size() - 1;
		for (int i = lasti; i >= 0; i--)
			if (listStudent.get(i).getGPA() > listStudent.get(lasti).getGPA())
				break;
			else {
				listStudent.get(i).showInfo();
				System.out.println();
			}
	}

	public void showInfoStudentsAlphabet() {
		Collections.sort(listStudent, new NameStudentComparator());
		showTitle();
		for (Student student : listStudent) {
			student.showInfo();
			System.out.println();
		}
		System.out.println();
	}

	public void showListStudentsGrant() {
		Collections.sort(listStudent, new MarkComparator());
		System.out.println("\t-Danh sách sinh viên được học bổng:");
		showTitle();
		for (Student x : listStudent) {
			if (x.checkStudentGrant()) {
				x.showInfo();
				System.out.println();
			}
		}
		System.out.println();
	}

	public void showTitle() {
		System.out.printf("| %-11s| %-20s| %-11s| %-4s| %-20s| %-25s| %-9s", "Mã SV", "Họ tên", "Ngày sinh", "GT",
				"Địa chỉ", "Email", "GPA");
		System.out.println();
	}
}
