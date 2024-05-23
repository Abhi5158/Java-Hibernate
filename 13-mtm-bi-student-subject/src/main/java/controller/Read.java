package controller;

import java.util.List;
import hibernateUtility.HibernateUtility;
import model.Student;
import model.Subject;

public class Read {

	public static void main(String[] args) {
		Student student1 = HibernateUtility.entityManager.find(Student.class, 1);
		
		System.out.println("Student details : ");
		System.out.println("First student Id : " +student1.getStudentId());
		System.out.println("Student1 Name : "+student1.getStudentName());
		System.out.println("Student1 Age : "+student1.getStudentAge());
		
		List<Subject> subjects = student1.getSubjects();
		for (Subject subject : subjects) {
			System.out.println("Subject Details : ");
			System.out.println("First Subject id : "+subject.getSubjectId());
			System.out.println("Subject Name : "+subject.getSubjectName());
			System.out.println("Subject code : "+subject.getSubjectCode());
		}
		
		Student student2 = HibernateUtility.entityManager.find(Student.class, 2);
		
		System.out.println("Second student Id : " +student2.getStudentId());
		System.out.println("Student2 Name : "+student2.getStudentName());
		System.out.println("Student2 Age : "+student2.getStudentAge());

		List<Subject> subjects2 = student2.getSubjects();
		for (Subject subject : subjects2) {
			System.out.println("Subject Details : ");
			System.out.println("First Subject id : "+subject.getSubjectId());
			System.out.println("Subject Name : "+subject.getSubjectName());
			System.out.println("Subject code : "+subject.getSubjectCode());
		}
		
	}

}
