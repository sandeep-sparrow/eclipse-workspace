package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteSandeepStudentDemo {

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
			
			// get Student sandeep from database
			int theId = 1;
			System.out.println("Getting Student Sandeep From Database\n");
			
			Student theStudent = session.get(Student.class, theId);
			
			System.out.println("\nStudent...");
			System.out.println(theStudent);
			
			System.out.println("\nStudent Courses...");
			System.out.println("\n" + theStudent.getCourses());
			
			// delete student
			System.out.println("\nDeleting Student...");
			session.delete(theStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nStudent Data Deleted Successfully!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
