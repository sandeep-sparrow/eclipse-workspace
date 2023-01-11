package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(InstructorDetail.class)
				                                    .addAnnotatedClass(Course.class)
				                                    .addAnnotatedClass(Review.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// start transaction
			System.out.println("Begin Transaction!\n");
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course course = session.get(Course.class, theId);
			
			// print the course
			System.out.println("Printing Course Details\n");
			System.out.println(course);
			
			// print the course reviews
			System.out.println("Printing the Course Review\n");
			// Hibernate run a separate select in the Reviews table due to FetchType.LAZY
			// an on demand search
			System.out.println(course.getReviews());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nCourses and Reviews data is Saved!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
