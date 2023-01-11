package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			System.out.println("Begin Transaction 1 !\n");
			session.beginTransaction();
			
			// create a course
			Course course = new Course("Pac Man - Ultra Legend Arcade Game!");
			
			// save the course
			System.out.println("\nSaving the course 1...");
			session.save(course);
			System.out.println("\nSaved the course 1: " + course);
			
			// create the students
			Student student1 = new Student("Sandeep","Prajapati","sandeep.p4856@gmail.com");
		    Student student2 = new Student("Chad","Darby","chad.darby@gmail.com");
		    Student student3 = new Student("Dumb","Idiot","dumb.idiot.io@gmail.com");
		    
		    // add students to course
			course.addStudent(student1);
			course.addStudent(student2);
			course.addStudent(student3);
			
			// save the students
			System.out.println("Saving Student Details!!!\n");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			System.out.println("Saved students: \n" + course.getStudents());
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("\nCourses and Student data is Saved !!!");
			
			session = factory.getCurrentSession();
			System.out.println("Begin Transaction 2 !\n");
			session.beginTransaction();
			
			// create a course
			course = new Course("God of war, Ultra Edition Course");
			
			// save the course
			System.out.println("\nSaving the course 2...");
			session.save(course);
			System.out.println("\nSaved the course 2: " + course);
			
			// add students to the course
			Student student4 = new Student("Bhargavi","Prajapati","bhargavi.p4856@gmail.com");
		    Student student5 = new Student("Miko","Darby","miko.darby@gmail.com");
		    Student student6 = new Student("Smart","Idiot","smart.idiot.io@gmail.com");
		    
			course.addStudent(student1);
			course.addStudent(student4);
			course.addStudent(student5);
			course.addStudent(student6);
			
			// save the students
			System.out.println("Saving Student Details!!!\n");
			session.save(student4);
			session.save(student5);
			session.save(student6);
			System.out.println("Saved students: \n" + course.getStudents());
			
			session.save(course); // this will save the course but also cascade the save to the reviews...
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("\nCourses and Student data is Saved !!!");
			
			System.out.println("\nDone!!!");
			
		}finally{
			// Add a clean up code, to avoi connection leaks
			session.close();
			factory.close();
			
		}

	}

}
