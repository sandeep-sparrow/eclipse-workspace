package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to update the existing object from database
			int studentId = 1;
			
			// start transaction
			System.out.println("\nBegin Transaction!");
			session.beginTransaction();
			
			// retrieve student based on the id: primary key
			System.out.println("\nGetting Student with Id: " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("\nStudent Get complete: " + myStudent);
			
			// Get the First Name of the Student to Sandy
			System.out.println("Updating Student First Name!\n");
			myStudent.setFirstName("Sandy");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// NEW CODE - for Bulk Update
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Updating for Student with Id = 1 and Id = 3
			System.out.println("\nUpdating Student table for student with Id = 1 and Id = 3");
			
			session.createQuery("update Student set email='Sandeep.luv2code@gmail.com'"
			                  + " where id=1").executeUpdate();
			
			session.createQuery("update Student set email='Bhargavi.prajapati1196@gmail.com'"
					          + " where id=3").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student Update Complete, you saved the world!!!");
			
		}finally{
			factory.close();
			
		}

	}

}
