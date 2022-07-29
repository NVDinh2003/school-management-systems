package comaprator;

import java.util.Comparator;

import data.Student;

public class MarkComparator implements Comparator<Student> {

	
	//Comparator<Student> cm1=Comparator.comparing(Student::getName); 
//	  Collections.sort(al,cm1);  
//	  System.out.println("Sorting by Name");  
	public int compare(Student sd1, Student sd2) {
		if (sd1.getGPA() == sd2.getGPA()) {
			return 0;
		} else if (sd1.getGPA() < sd2.getGPA()) {
			return 1;
		} else {
			return -1;
		}
	}


	
}
