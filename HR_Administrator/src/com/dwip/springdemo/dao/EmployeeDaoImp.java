package com.dwip.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwip.springdemo.entity.EmployeeTable;


@Repository
public class EmployeeDaoImp implements EmployeeDAO {
	
	
	//make DAO talk to database
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	public List<EmployeeTable> getEmployee() {
		
		//get hibernate current session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//Query the database
		Query<EmployeeTable> query=currentSession.createQuery("from EmployeeTable order by firstName", EmployeeTable.class);
		
		//query and sort customer ny lastName
		//Query<EmployeeTable> query=currentSession.createQuery("from Employee order by lastName", EmployeeTable.class);
		
		
		//execute and get result of the query
		List<EmployeeTable> employees=query.getResultList();
		
		
		return employees;//returns list of employee......USE THIS IN LIST_EMPLOYEE FORM... to display in web page
	}



	@Override
	public void saveEmployee(EmployeeTable theEmployee) {
		// TODO Auto-generated method stub
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
//		//save to database
//		currentSession.save(theCustomer);
		
		//save or update to database
		currentSession.saveOrUpdate(theEmployee);
		
	}



	@Override
	public EmployeeTable getEmployee(int theId) {
		// TODO Auto-generated method stub
		
		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using primary key
		EmployeeTable theEmployee=currentSession.get(EmployeeTable.class, theId);
		
		
				
		return theEmployee;
	}



	@Override
	public void deleteEmployee(int theId) {
		// TODO Auto-generated method stub

		//get current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
				
		//now delete from database using primary key
		Query theQuery=currentSession.createQuery("delete from EmployeeTable where id=:employeeId");//here Customer is the Class not database
		
		theQuery.setParameter("employeeId", theId);
		
		//execute delete/update 
		theQuery.executeUpdate();
		
		
	}

}
