package comaprator;

import java.util.Comparator;

import data.Student;

public class NameStudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student std1, Student std2) {
		return std1.getLastName().compareTo(std2.getLastName());
	}
}
