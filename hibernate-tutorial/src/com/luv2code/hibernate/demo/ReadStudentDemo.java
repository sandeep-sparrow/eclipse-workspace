package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// create student object
            String theDateOfBirthStr = "31/12/1998";
            
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
            
			System.out.println("Creating a new student object!");
			Student myStudent = new Student("Daffy","Duck","DDaf846@gmail.com",theDateOfBirth);
			
			// start transaction
			System.out.println("Begin Transaction!");
			session.beginTransaction();
			
			// save the student object to DB
			System.out.println("Saving the world!!!");
			session.save(myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// find out student ID
			System.out.println("Saved Student Generated ID: " + myStudent.getId());
			
			// read student from database using primary key
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nGetting Student with ID: " + myStudent.getId());
			
			Student yourStudent = session.get(Student.class, myStudent.getId());
			
			System.out.println("Get Complete: " + yourStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student data Save and Retrival Completed, you saved the world!!!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			factory.close();
			
		}

	}

}
