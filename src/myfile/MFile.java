//package myfile;
//
//import java.io.*;
//
//import data.Student;
//
//public class MFile {
//	public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//		StringBuilder s = new StringBuilder("Nguyen An");
//		Student s1 = new Student(s, "Nam", "04/04/2003", "Ha Tinh", "21T1020017", "dinh@gmai.com", 3.2);
//
//		File myFolder = new File("SaveFile");
//		if (!myFolder.exists())
//			myFolder.mkdir();
//		File myFile = new File("SaveFile/saveFile.txt");
//		if (!myFile.exists())
//			myFile.createNewFile();
//
////		============== 
//
//		try {
//			FileOutputStream fo = new FileOutputStream("Student.txt");
//			ObjectOutputStream oos = new ObjectOutputStream(fo);
//			oos.writeObject(s1);
//			fo.close();
//			oos.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//		FileInputStream fi = new FileInputStream("Student.txt");
//		ObjectInputStream ois = new ObjectInputStream(fi);
//		Student s2 = (Student) ois.readObject();
//		
//		System.out.println(s2.toString());
//
//	}
//}
