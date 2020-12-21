package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{

	private SessionFactory factory; 	
	
	public CustomerDaoImpl(SessionFactory factory) {		
		this.factory = factory;
	}

	@Override
	@Transactional
	
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = factory.getCurrentSession();
		Query<Customer>theQuery=session.createQuery("from Customer",Customer.class);
		List<Customer> customers=theQuery.getResultList();
		return customers;
	}

}
