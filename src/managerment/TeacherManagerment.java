package managerment;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import comaprator.NameTeacherComparator;
import comaprator.SalaryTeacherComparator;
import data.Teacher;

public class TeacherManagerment {
	List<Teacher> listTeacher;

	public TeacherManagerment() {
		listTeacher = new LinkedList<Teacher>();
	}

	public void addTeacher() {
		Teacher t = new Teacher(null, null, null, null, null, null, null, null);
		t.inputInfo();
		listTeacher.add(t);
	}

	public void showInfoAllTeachers() {
		showTitle();
		for (Teacher t : listTeacher) {
			t.showInfo();
			System.out.println();
		}
		System.out.println();
	}

	public void searchTeacherByID(String TeacherID) {
		boolean check = false;
		for (Teacher x : listTeacher)
			if (x.getMaGiaoVien().equalsIgnoreCase(TeacherID)) {
				check = true;
				showTitle();
				x.showInfo();
				System.out.println();
				break;
			}

		if (!check)
			System.out.println("Không có giáo viên nào có mã là " + TeacherID);
	}

	public void showTeacherMaxLuong() {
		Collections.sort(listTeacher, new SalaryTeacherComparator());
		double maxSalary = Double.parseDouble(listTeacher.get(0).getLuong());
		System.out.println("Giáo viên có lương cao nhất: ");
		showTitle();
		for (Teacher x : listTeacher)
			if (Double.parseDouble(x.getLuong()) == maxSalary) {
				x.showInfo();
				System.out.println();
			}
		System.out.println();
	}

	public void showTitle() {
		System.out.printf("| %-11s| %-20s| %-11s| %-4s| %-20s| %-12s| %-20s| %-10s", "Mã GV", "Họ tên", "Ngày sinh",
				"GT", "Địa chỉ", "Điện thoại", "Thuộc khoa", " Lương");
		System.out.println();
	}

	public void showInfoTeachersAlphabet() {
		Collections.sort(listTeacher, new NameTeacherComparator());
		showTitle();
		for (Teacher t : listTeacher) {
			t.showInfo();
			System.out.println();
		}

		System.out.println();
	}

	public void showListTeachersTangDanTheoLuong() {
		Collections.sort(listTeacher, new SalaryTeacherComparator());
		showTitle();
		for (Teacher x : listTeacher) {
			x.showInfo();
			System.out.println();
		}
		System.out.println();
	}
}
