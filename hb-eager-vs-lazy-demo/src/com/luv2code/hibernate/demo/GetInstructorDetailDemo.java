package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(InstructorDetail.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// start transaction
			System.out.println("Begin Transaction!\n");
			session.beginTransaction();
			
			// get Instructor Detail by primary key
			int theId = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			if(instructorDetail!=null) {
				// print Instructor Detail
				System.out.println("\nInstructor Detail Found: " + instructorDetail);
				Instructor instructor = instructorDetail.getInstructor();
				//print Instructor Detail
				if(instructor!=null) {
					System.out.println("\nInstructor Found: " + instructor);
				}else {
					System.out.println("\nInstructor Not Found");
				}
			}else {
				System.out.println("\nInstructor Detail Not Found for given Id");
			}

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nInstructor data is bidirectionally accessibly, you saved the world!!!");
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}	
		finally{
			factory.close();
			// handles connection leak issue - inorder to cleaning up connection pool
			session.close();
		}

	}

}
