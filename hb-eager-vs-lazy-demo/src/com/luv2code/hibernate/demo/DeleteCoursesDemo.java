package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCoursesDemo {

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
			
			// get a course
			int[] theIds = {14,15,16,20,21,22};
			for(int theId: theIds){
				Course tempCourse = session.get(Course.class, theId);
				
				// delete course
				if(tempCourse==null) {
					System.out.println("\nNot Courses Found for the given Id: " + theId);
					System.out.println("\n");
				}else {
					System.out.println("\nCourses: " + tempCourse);
					session.delete(tempCourse);
				}
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nDone!!!");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
