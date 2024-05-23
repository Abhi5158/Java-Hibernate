package controller;


import hibernateUtility.HibernateUtility;
import model.Student;
import model.Subject;

public class Delete {

	public static void main(String[] args) {
		Student student1 = HibernateUtility.entityManager.find(Student.class, 1);
		Student student2 = HibernateUtility.entityManager.find(Student.class, 2);
		Subject subject1 = HibernateUtility.entityManager.find(Subject.class, 11);
		

		System.out.println("Student details : ");
		System.out.println("First student Id : " +student1.getStudentId());
		System.out.println("Student1 Name : "+student1.getStudentName());
		System.out.println("Student1 Age : "+student1.getStudentAge());
		
		System.out.println("Subject Details : ");
		System.out.println("First Subject id : "+subject1.getSubjectId());
		System.out.println("Subject Name : "+subject1.getSubjectName());
		System.out.println("Subject code : "+subject1.getSubjectCode());
		student1.setSubjects(null);
		subject1.setStudents(null);
		student2.setSubjects(null);
		
		HibernateUtility.entityTransaction.begin();
		HibernateUtility.entityManager.merge(student1);
		HibernateUtility.entityManager.merge(student2);
		HibernateUtility.entityManager.merge(subject1);
		HibernateUtility.entityManager.remove(subject1);
		//HibernateUtility.entityManager.remove(student1);
		HibernateUtility.entityTransaction.commit();
		System.out.println("Removed successfully");
	}

}
