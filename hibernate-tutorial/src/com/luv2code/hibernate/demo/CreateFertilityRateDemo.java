package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.FertilityRate;

public class CreateFertilityRateDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(FertilityRate.class)
				                                    .buildSessionFactory();
		
		// Create Session
		Session session = factory.getCurrentSession();
		
		try {
			// Create Entity object
			FertilityRate FR1 = new FertilityRate(3,"Bihar","India");
			FertilityRate FR2 = new FertilityRate(2.9,"Meghalaya","India");
			FertilityRate FR3 = new FertilityRate(2.4,"Uttar Pradesh","India");
			FertilityRate FR4 = new FertilityRate(2.3,"Jharkhand","India");
			FertilityRate FR5 = new FertilityRate(2.2,"Manipur","India");
			FertilityRate FR6 = new FertilityRate(1.9,"Gujarat","India");
			
			// start transaction
			System.out.println("Starting Transaction!\n");
			session.beginTransaction();
			
			// save the entity objects to the Database
			System.out.println("As per the NFHS-5 Data, only 5 states in India have Fertility " 
			                 + "rate above the Replacement Rate of 2.1\n");
			session.save(FR1);
			session.save(FR2);
			session.save(FR3);
			session.save(FR4);
			session.save(FR5);
			session.save(FR6);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
		}finally{
			factory.close();
		}

	}

}
