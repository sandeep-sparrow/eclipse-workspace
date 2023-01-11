package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.util.SortUtils;

//spring be able to component scan, this is always applied to DAO implimentation...
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers(int theSortField) {
		
		// create session using session factory
		// due to the use of the Transactional Annotation there is not need to beginTransaction or close...or commmit
		Session session = sessionFactory.getCurrentSession();
		
		// determine the sort field
		String theFieldName = null;
		
		switch(theSortField) {
			case SortUtils.FIRST_NAME:
				theFieldName = "firstName";
				break;
			case SortUtils.LAST_NAME:
				theFieldName = "lastName";
				break;
			case SortUtils.EMAIL:
				theFieldName = "email";
				break;
			default:
				// if nothing matches the default to sort by last name
				theFieldName = "lastName";
			
		}
		
		// create a query
		String queryString = "from Customer order by " + theFieldName;
		
		// create a query...sort by the last name
		Query<Customer> theQuery = session.createQuery(queryString, Customer.class);
		
		// execute query and get result list 
		List<Customer> customers = theQuery.getResultList();
		
		// return the results;
		return customers;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// create session using session factory
		// due to the use of the Transactional Annotation there is not need to beginTransaction or close...or commmit
		Session session = sessionFactory.getCurrentSession();
		
		// create a object
		// based on primary key it will decided to UPDATE or INSERT   
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		// create session using session factory
		Session session = sessionFactory.getCurrentSession();
		
		// get the customer object from the database
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		// create session using session factory
		Session session = sessionFactory.getCurrentSession();
		
		// delete object using the PK
		// @SuppressWarnings("rawtypes")
		// Query theQuery =
		//	  	session.createQuery("delete from Customer where id=:customerId");
		
		// theQuery.setParameter("customerId", theId);

		// get the customer object from the database

		Customer theCustomer = session.get(Customer.class, theId);

		// delete the customer object from the database

		session.delete(theCustomer);
		
		// theQuery.executeUpdate();
		
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {
		
		// get the current session from session factory
		Session session = sessionFactory.getCurrentSession();
		
		// create query
		@SuppressWarnings("rawtypes")
		Query theQuery = null;
		
		// only search by the name if theSearchName is not empty
		if(theSearchName != null && theSearchName.trim().length() > 0) {
			// search for firstName or lastName ... case insensitive...
			theQuery = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
			
			theQuery.setParameter("theName" , "%" + theSearchName.toLowerCase() + "%");
		}else {
			// theSearchName is empty... so just get all customers...
            theQuery = session.createQuery("from Customer", Customer.class);            
		}
		
		// execute the query and get the customer list....
		@SuppressWarnings("unchecked")
		List<Customer> customers = theQuery.getResultList();
		
		return customers;
	}


}
