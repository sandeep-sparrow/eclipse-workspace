package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class DeleteInstructorDetailDemo {

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
			int theId = 5;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);

			// delete the InstructorDetail
			System.out.println("\nDeleting InstructorDetail: " + instructorDetail);
			System.out.println("\nIt should not delete a Instructor record due to absence of CascadeType.REMOVE");
			
			// remove the associated object reference
			// break bi-directional link
			
			instructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(instructorDetail);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nInstructor data is Cascade Delete, you saved the world!!!");
			
		}
		finally{
			factory.close();
			// handles connection leak issue - inorder to cleaning up connection pool
			session.close();
		}

	}

}
