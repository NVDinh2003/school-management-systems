
package main;

import managerment.StudentManagerment;
import managerment.TeacherManagerment;
import util.CheckInput;
import util.Menu;

public class Main {

	public static void main(String[] args) {
		StudentManagerment studentManager = new StudentManagerment();
		TeacherManagerment teacherManager = new TeacherManagerment();
		Menu SMenu = new Menu("Managerment System");
		SMenu.addNewOption("1. Quản lý sinh viên");
		SMenu.addNewOption("2. Quản lý giáo viên");
		SMenu.addNewOption("3. Exit !");
		int choice;
		do {
			SMenu.printMenu();
			choice = SMenu.getChoice();
			switch (choice) {
			case 1:

				studentMenu(studentManager);
				break;
			case 2:

				teacherMenu(teacherManager);
				break;
			case 3:
				System.out.println("Good bye ! See you next time !\n");
				break;
			}
		} while (choice != SMenu.getMaxOption());

	}

	public static void studentMenu(StudentManagerment studentManager) {
		CheckInput ck = new CheckInput();
		Menu SMenu = new Menu("Student Managerment System");

		SMenu.addNewOption("1. Thêm 1 sinh viên");
		SMenu.addNewOption("2. Hiển thị tất cả các sinh viên");
		SMenu.addNewOption("3. Tìm kiếm sinh viên theo mã SV");
		SMenu.addNewOption("4. Cập nhật thông tin sinh viên");
		SMenu.addNewOption("5. Hiển thị sinh viên có điểm TB cao nhất, thấp nhất");
		SMenu.addNewOption("6. Hiển thị sinh viên theo Alphabet");
		SMenu.addNewOption("7. Hiển thị tất cả sinh viên được học bổng");
		SMenu.addNewOption("8. Xóa sinh viên theo mã sinh viên");
		SMenu.addNewOption("9. Back");

		int choice;
		do {
			SMenu.printMenu();
			choice = SMenu.getChoice();
			switch (choice) {
			case 1:
				studentManager.insertStudent();
				break;
			case 2:
				studentManager.showInforAllStudent();
				break;
			case 3:
				String id = ck.inputString("Nhập mã sinh viên cần tím kiếm: ");
				studentManager.searchStudentByID(id);
				break;
			case 4:
				String newID = ck.inputString("Nhập mã sinh viên cần cập nhật: ");
				studentManager.updateAStudentByID(newID);
				break;
			case 5:
				studentManager.showSMaxMarkAndMinMark();
				break;
			case 6:
				studentManager.showInfoStudentsAlphabet();
				break;
			case 7:
				studentManager.showListStudentsGrant();
				break;
			case 8:
				String removeID = ck.inputString("Nhập mã sinh viên cần xóa: ");
				studentManager.removeAStudentByID(removeID);
				break;
			case 9:
				break;
			}
		} while (choice != SMenu.getMaxOption());

	}

	public static void teacherMenu(TeacherManagerment teacherManager) {
		CheckInput ck = new CheckInput();
		Menu SMenu = new Menu("Teacher Managerment System");

		SMenu.addNewOption("1. Thêm giáo viên");
		SMenu.addNewOption("2. Hiển thị tất cả các giáo viên");
		SMenu.addNewOption("3. Hiển thị có lương cao nhất");
		SMenu.addNewOption("4. Tìm kiếm giáo viên theo mã GV");
		SMenu.addNewOption("5. Hiển thị giáo viên theo Alphabet");
		SMenu.addNewOption("6. Hiển thị giáo viên theo lương tăng dần");
		SMenu.addNewOption("7. Back");

		int choice;
		do {
			SMenu.printMenu();
			choice = SMenu.getChoice();
			switch (choice) {
			case 1:
				teacherManager.addTeacher();
				break;
			case 2:
				teacherManager.showInfoAllTeachers();
				;
				break;
			case 3:
				teacherManager.showTeacherMaxLuong();
				break;
			case 4:
				String id = ck.inputString("Nhập mã giáo viên cần tìm kiếm: ");
				teacherManager.searchTeacherByID(id);
				break;
			case 5:
				teacherManager.showInfoTeachersAlphabet();
				break;
			case 6:
				teacherManager.showListTeachersTangDanTheoLuong();
				break;
			case 7:
				break;
			}
		} while (choice != SMenu.getMaxOption());

	}

}
