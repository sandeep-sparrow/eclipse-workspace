package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// Create Session Factory
		System.out.println("\nSession Factory Created!!!\n");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		System.out.println("\nSession Created!!!");
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// start transaction
			System.out.println("\nSession - Begin Transaction!");
			session.beginTransaction();
			
			// query 1 students for all students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display the students
			System.out.println("\nQuery 1 Display all the Students\n");
			displayStudents(theStudents);
			
			// query 2 students: who's last name is Prajapati
			theStudents = session.createQuery("from Student s where s.lastName='prajapati'").getResultList();
			
			System.out.println("\nQuery 2 Students that have last name as Prajapati\n");
			displayStudents(theStudents);
			
			// query 3 students: last name of prajapati and first name of sandeep
			theStudents = session.createQuery("from Student s where " 
					                        + "s.lastName='prajapati' and s.firstName='sandeep'").getResultList(); 
			
			System.out.println("\nQuery 3 Students that have last name as Prajapati and first name as Sandeep\n");
			displayStudents(theStudents);
			
			// query 4 students: using like cluase
			theStudents = session.createQuery("from Student s where " 
					                        + "s.email LIKE '%gmail.com'").getResultList(); 
			
			System.out.println("\nQuery 4 Students that have email LIKE 'gmail.com'\n");
			displayStudents(theStudents);
			
			// commit the transaction
			System.out.println("\nSession - Commit Transaction!");
			session.getTransaction().commit();
			
			System.out.println("\nStudent Query Successfully!!!");
			
			// close session, end transaction
			session.close();
			System.out.println("\nSession Closed!!!\n");
			
		}finally{
			factory.close();
			System.out.println("\nSession Factory Closed!!!");
			
		}

	}

	private static void displayStudents(List<Student> theStudents) {
		for(Student student : theStudents) {
			System.out.println(student);
		}
	}

}
