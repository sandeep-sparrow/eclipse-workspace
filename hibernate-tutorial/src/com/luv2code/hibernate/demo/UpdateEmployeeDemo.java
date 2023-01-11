package com.luv2code.hibernate.demo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;

public class UpdateEmployeeDemo {

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
			
			// Start Transactions 
			System.out.println("\nStarting Transaction on current session");
			session.beginTransaction();
			
			// Update Code
			System.out.println("\nUpdating Employee Details using Id: Primary key");
			int employeeId = 1;
			Employee myEmployee = session.get(Employee.class, employeeId);
			
			myEmployee.setFirstName("Sandeep");
			myEmployee.setLastName("Prajapati");
			
			// commit the changes
			session.getTransaction().commit();
			System.out.println("\nCommit Complete 1");
			
			// Note: you have to being the transaction of the current session again because on commit the transactions get's ended
			//       Just like how the cursor get's closed automatically on execution of commit in IBM Mainframe Environment 
			//       when doing in COBOL or PL/1
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			employeeId = 2;
			myEmployee = session.get(Employee.class, employeeId);
			
			myEmployee.setFirstName("Priyanka");
			myEmployee.setLastName("Wagh");
			
			// commit the changes
			session.getTransaction().commit();
			System.out.println("\nCommit Complete 2");
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			employeeId = 3;
			myEmployee = session.get(Employee.class, employeeId);
			
			myEmployee.setEmail("sashi.luv2codes@gmail.com");
			
			// commit the changes
			session.getTransaction().commit();
			System.out.println("\nCommit Complete 3");
			
			System.out.println("\nSession Task Complete, Done!");
			
		}finally {
			System.out.println("\nClosing Session Factory\n");
			factory.close();
			System.out.println("\nSession Factory closed");
		}

	}

}
