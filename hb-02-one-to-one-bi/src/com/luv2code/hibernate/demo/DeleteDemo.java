package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.*;

public class DeleteDemo {

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
			System.out.println("Begin Transaction!");
			session.beginTransaction();
			
			// get instructor by primary key
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor Found: " + instructor);
			
			// delete the instructor
			if(instructor!=null) {
				System.out.println("Deleting Instructor: " +instructor);
				// reference to the session delete method...
				// @OneToOne(cascade=CascadeType.ALL) will delete the details records also...
				session.delete(instructor);
			}else {
				System.out.println("Not Instructor with given Id found!");
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Instructor data is Deleted, you saved the world!!!");
			
		}finally{
			factory.close();
			
		}

	}

}
