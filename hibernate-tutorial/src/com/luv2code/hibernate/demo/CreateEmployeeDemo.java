package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		System.out.println("Creating new Session Factory\n");
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
				                                    .addAnnotatedClass(Employee.class)
				                                    .buildSessionFactory();
		
		// Create Session
		System.out.println("\nCreating new Session");
		Session session = factory.getCurrentSession();
		
		try {
			
			// create employee objects, here i will be creating 2 employees
			System.out.println("\nCreating new Employees");
			Employee emp1 = new Employee("sandeep","prajapati","sandeep.p4856@gmail.com","DXC Technology");
			Employee emp2 = new Employee("priyanka","wagh","priyanaka.luv2code@gmail.com","Coforge");
			Employee emp3 = new Employee("Sashi","Tharoor","Shashi.luv2codes@gmail.com","Rajya Sabha");
			
			// Start Transactions 
			System.out.println("\nStarting Transaction on current session");
			session.beginTransaction();
			
			// save to database using session transaction
			System.out.println("\nSaving Emplpoyee java objects to MYSQL using Session Transaction");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			System.out.println("\nSaving Complete!");
			
			// commit the changes
			session.getTransaction().commit();
			System.out.println("\nCommit Complete");
			
			System.out.println("\nSession Task Complete, Done!");
			
		}finally {
			System.out.println("\nClosing Session Factory\n");
			factory.close();
			System.out.println("\nSession Factory closed");
		}

	}

}
