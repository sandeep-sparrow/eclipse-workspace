package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Instructor.class)
				                                    .addAnnotatedClass(InstructorDetail.class)
				                                    .addAnnotatedClass(Course.class)
				                                    .addAnnotatedClass(Review.class)
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// start transaction
			System.out.println("Begin Transaction!\n");
			session.beginTransaction();
			
			// get the course pac man
			int theCourseId = 10;
			Course course = session.get(Course.class, theCourseId);
			
			// print the course
			System.out.println("Delete the Course\n");
			System.out.println(course);
			
			// delete the course
			session.delete(course);
			// due to cascade all, it should delete the course and also the reviews...
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nCourses and Reviews data is Removed!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
