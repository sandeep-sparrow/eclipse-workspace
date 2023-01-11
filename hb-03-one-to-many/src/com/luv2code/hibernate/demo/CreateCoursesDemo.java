package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			System.out.println("Begin Transaction!\n");
			session.beginTransaction();
			
			// get instructor using id
			int theId = 2;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// create courses object
			Course course1 = new Course("Air Guitar 1 - The Ultimate Guide");
			Course course2 = new Course("Java Hibernate Programming Updated Version !");
			Course course3 = new Course("The Pin Ball 1 - Master Class!");
			
			// add courses to instructor
			
			tempInstructor.add(course1);
			tempInstructor.add(course2);
			tempInstructor.add(course3);
			
			// course1.setInstructor(tempInstructor);
			// course2.setInstructor(tempInstructor);
			// course3.setInstructor(tempInstructor);
			
			// save courses
			session.save(course1);
			session.save(course2);
			session.save(course3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nCourses data is Saved!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
