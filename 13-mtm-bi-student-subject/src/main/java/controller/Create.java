package controller;

import java.util.ArrayList;
import java.util.List;

import hibernateUtility.HibernateUtility;
import model.Student;
import model.Subject;

public class Create {

	public static void main(String[] args) {
		Subject sub1 = new Subject();
		Subject sub2 = new Subject();
		
		sub1.setSubjectId(11);
		sub1.setSubjectName("English");
		sub1.setSubjectCode("452");
		
		sub2.setSubjectId(12);
		sub2.setSubjectName("Maths");
		sub2.setSubjectCode("22");
		
		Student stu1 = new Student();
		Student stu2 = new Student();
		
		
		List<Subject> subjects = new ArrayList<Subject>();
		subjects.add(sub1);
		subjects.add(sub2);
		stu1.setSubjects(subjects);
		stu2.setSubjects(subjects);
		
		stu1.setStudentId(1);
		stu1.setStudentName("Obito");
		stu1.setStudentAge(23);
		
		stu2.setStudentId(2);
		stu2.setStudentName("Pain");
		stu2.setStudentAge(23);
		
		List<Student> students = new ArrayList<Student>();
		students.add(stu1);
		students.add(stu2);
		sub1.setStudents(students);
		sub2.setStudents(students);
		
		HibernateUtility.entityTransaction.begin();
		HibernateUtility.entityManager.persist(stu1);
		for (Subject subject : subjects) {
			HibernateUtility.entityManager.persist(subject);
		}
		HibernateUtility.entityManager.persist(stu2);
		for (Subject subject : subjects) {
			HibernateUtility.entityManager.persist(subject);
		}
		HibernateUtility.entityTransaction.commit();
	}

}
