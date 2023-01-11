package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			
			// start transaction
			System.out.println("luv2code: Begin Transaction!\n");
			session.beginTransaction();
			
			// get instructor using id
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("\nluv2code: Instructor: " + tempInstructor);
			
			System.out.println("\nluv2code: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			System.out.println("\nluv2code: The session is now closed!");
			// option1: call getter method while session is open	
			
			// since the courses are lazy loaded... 
			// get courses for the instructor 
			System.out.println("\nluv2code: Courses: " + tempInstructor.getCourses());
			
			// commit the transaction
			// session.getTransaction().commit();
			
			System.out.println("\nluv2code: Done!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
