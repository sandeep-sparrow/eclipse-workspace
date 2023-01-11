package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
			// create a course
			Course course = new Course("Pac Man - Ultra Legend Arcade Game!");
			
			// add reviews to the course
			course.addReview(new Review("Great Course, Loved it"));
			course.addReview(new Review("Cool Course, Job well done"));
			course.addReview(new Review("What a dumb Course, You are an Idiot!"));
			
			// save the course... and leverage the cascade all :)
			System.out.println("Saving Courses!!!\n");
			System.out.println(course);
			System.out.println(course.getReviews());
			
			session.save(course); // this will save the course but also cascade the save to the reviews...
			
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
