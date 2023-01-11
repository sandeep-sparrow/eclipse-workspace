package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			
			// start transaction
			System.out.println("\nBegin Transaction!");
			session.beginTransaction();
			
			// Delete student with Id=5
			System.out.println("\nDeleting student with Id=5");
			session.createQuery("delete from Student where id=5").executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student Delete Complete, you saved the world!!!");
			
		}finally{
			factory.close();
			System.out.println("\nFactory Closed");
			
		}

	}

}
