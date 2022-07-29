package comaprator;

import java.util.Comparator;

import data.Teacher;

public class SalaryTeacherComparator implements Comparator<Teacher> {
	public int compare(Teacher t1, Teacher t2) {
		double salaryT1 = Double.parseDouble(t1.getLuong());
		double salaryT2 = Double.parseDouble(t2.getLuong());
		if (salaryT1 == salaryT2) {
			return 0;
		} else if (salaryT1 > salaryT2) {
			return 1;
		} else {
			return -1;
		}
	}
}
