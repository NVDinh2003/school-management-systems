package comaprator;

import java.util.Comparator;

import data.Teacher;

public class NameTeacherComparator implements Comparator<Teacher> {

	@Override
	public int compare(Teacher std1, Teacher std2) {
		return std1.getLastName().compareTo(std2.getLastName());
	}
}
