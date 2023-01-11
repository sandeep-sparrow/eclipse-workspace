package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Student.class)
													.buildSessionFactory();
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// use the session object to save the object
			
			// create student object
			String theDateOfBirthStr = "13/11/1994";
			
			Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);
			
			System.out.println("Creating a new student object!");
			Student myStudent = new Student("Sandeep","Prajapati","sandeep.p4846@gmail.com",theDateOfBirth);
			
			// start transaction
			System.out.println("Begin Transaction!");
			session.beginTransaction();
			
			// save the student object to DB
			System.out.println("Saving the world!!!");
			session.save(myStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Student data is Saved, you saved the world!!!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			factory.close();
			
		}

	}

}
