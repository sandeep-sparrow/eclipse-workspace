package com.luv2code.hibernate.demo;

import java.text.ParseException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

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
			System.out.println("Creating a three new student object!");
            String theDateOfBirthStr = "01/01/1900";
            
            Date theDateOfBirth = DateUtils.parseDate(theDateOfBirthStr);			
			Student myStudent1 = new Student("Paul","Wall","Paul.Wall1311@gmail.com",theDateOfBirth);
			Student myStudent2 = new Student("Bhargavi","Prajapati","bhargavi.prajapati1196@gmail.com",theDateOfBirth);
			Student myStudent3 = new Student("Apple","Series7","Apple.Series7@gmail.com",theDateOfBirth);
			
			// start transaction
			System.out.println("Begin Transaction!");
			session.beginTransaction();
			
			// save the student object to DB
			System.out.println("Saving the world!!!");
			session.save(myStudent1);
			session.save(myStudent2);
			session.save(myStudent3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("New Students data is Saved, you saved the world!!!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			factory.close();
			
		}


	}

}
