package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(InstructorDetail.class)
				                                    .addAnnotatedClass(Course .class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// create instructor, instructorDetail object
			Instructor instructor = new Instructor("Heenal","Prajapati","Heenal.p4856@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("www.google.com/youtube/Heenal","Heenal TV");
			
			// associate the object 
			instructor.setInstructorDetail(instructorDetail);
			
			// start transaction
			System.out.println("Begin Transaction 1!");
			session.beginTransaction();
			
			// save the Instructor object to DB
			// NOTE: This will ALSO save the details object
			// because of CascadeType.ALL
			System.out.println("\nSaving the world!!!");
			System.out.println("Saving Instructor 1: " + instructor);
			session.save(instructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			instructor = new Instructor("Chad","Darby","chad.dary.luv2code@gmail.com");
			instructorDetail = new InstructorDetail("www.google.com/youtube/chad","Darby TV");
			
			// link the instructor with details by calling the setting method
			// associate the object
			instructor.setInstructorDetail(instructorDetail);
			
			// start transaction
			session = factory.getCurrentSession();
			System.out.println("\nBegin Transaction 2!");
			session.beginTransaction();
			
			System.out.println("\nSaving the world again!!!");
			System.out.println("Saving Instructor 2: " + instructor);
			session.save(instructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nInstructors data is Saved!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
