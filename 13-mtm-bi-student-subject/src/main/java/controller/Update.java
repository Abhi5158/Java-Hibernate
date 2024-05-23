package controller;

import java.util.List;
import java.util.Scanner;

import hibernateUtility.HibernateUtility;
import model.Student;
import model.Subject;

public class Update {
	static Scanner myInput = new Scanner(System.in);

	public static void main(String[] args) {
		Student student1 = HibernateUtility.entityManager.find(Student.class, 1);

		System.out.println("Student details : ");
		System.out.println("First student Id : " + student1.getStudentId());
		System.out.println("Student1 Name : " + student1.getStudentName());
		System.out.println("Student1 Age : " + student1.getStudentAge());

		List<Subject> subjects = student1.getSubjects();
		for (Subject subject : subjects) {
			System.out.println("Subject Details : ");
			System.out.println("First Subject id : " + subject.getSubjectId());
			System.out.println("Subject Name : " + subject.getSubjectName());
			System.out.println("Subject code : " + subject.getSubjectCode());
		}

		Student student2 = HibernateUtility.entityManager.find(Student.class, 2);

		System.out.println("Second student Id : " + student2.getStudentId());
		System.out.println("Student2 Name : " + student2.getStudentName());
		System.out.println("Student2 Age : " + student2.getStudentAge());

		List<Subject> subjects2 = student2.getSubjects();
		for (Subject subject : subjects2) {
			System.out.println("Subject Details : ");
			System.out.println("First Subject id : " + subject.getSubjectId());
			System.out.println("Subject Name : " + subject.getSubjectName());
			System.out.println("Subject code : " + subject.getSubjectCode());

		}

		System.out.println("Enter entity to update the details : ");
		String entity = myInput.nextLine();
		if ("Student".equalsIgnoreCase(entity)) {
			System.out.println("Enter Stuent id to update : ");
			int studentToUpdate = myInput.nextInt();
			myInput.nextLine();
			Student updateStudent = HibernateUtility.entityManager.find(Student.class, studentToUpdate);
			do {
				System.out.println("Select Desired option : ");
				System.out.println("1.Update Student Name\n2.Update Student Age ");
				byte userchoice = myInput.nextByte();
				switch (userchoice) {
				case 1:
					System.out.println("Enter New Student name : ");
					updateStudent.setStudentName(myInput.nextLine());
					

					HibernateUtility.entityTransaction.begin();
					HibernateUtility.entityManager.merge(updateStudent);
					HibernateUtility.entityTransaction.commit();
					System.out.println("Updated Successfully!!!");
					break;
				case 2:
					System.out.println("Enter new age : ");
					updateStudent.setStudentAge(myInput.nextInt());
					myInput.nextLine();
					
					HibernateUtility.entityTransaction.begin();
					HibernateUtility.entityManager.merge(updateStudent);
					HibernateUtility.entityTransaction.commit();
					System.out.println("Updated Successfully!!!");
					break;
				default:
					System.out.println("Invalid input!! Please select a valid option;)");
					break;
				}
			} while (true);
		} else {
			System.out.println("Enter Subject id to update : ");
			int subjectToUpdate = myInput.nextInt();
			myInput.nextLine();
			Subject updateSubject = HibernateUtility.entityManager.find(Subject.class, subjectToUpdate);
			do {
				System.out.println("Select Desired option : ");
				System.out.println("1.Update Subject Name\n2.Update Subject Code ");
				byte userchoice = myInput.nextByte();
				switch (userchoice) {
				case 1:
					System.out.println("Enter the new subject name : ");
					updateSubject.setSubjectName(myInput.nextLine());
					
					HibernateUtility.entityTransaction.begin();
					HibernateUtility.entityManager.merge(updateSubject);
					HibernateUtility.entityTransaction.commit();
					System.out.println("Updated Successfully!!!");
					break;
					
				case 2 :
					System.out.println("Enter new subject code : ");
					updateSubject.setSubjectCode(myInput.nextLine());
					
					HibernateUtility.entityTransaction.begin();
					HibernateUtility.entityManager.merge(updateSubject);
					HibernateUtility.entityTransaction.commit();
					System.out.println("Updated Successfully!!!");
					break;

				default:
					System.out.println("Invalid input!! Please select a valid option;)");
					break;
				}
			} while (true);
		}
	}
}
