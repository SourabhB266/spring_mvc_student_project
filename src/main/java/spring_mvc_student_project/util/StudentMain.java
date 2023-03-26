package spring_mvc_student_project.util;

import spring_mvc_student_project.dao.StudentDao;
import spring_mvc_student_project.dto.Student;

public class StudentMain {
	
	public static void main(String[] args) {
		
		Student student = new Student();
	
		StudentDao dao = new StudentDao();
		
		student.setName("abhi");
		student.setAddress("BLR");
		student.setPhone(6677676563l);
		
		dao.saveStudent(student);
	}
}
