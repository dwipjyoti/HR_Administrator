package com.dwip.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dwip.springdemo.entity.UserTable;

@Repository
public class UserDaoImp implements UserDAO {
	
	//make DAO talk to database
		@Autowired
		private SessionFactory sessionFactory;


		@Override
		public Boolean checkUser(UserTable theUser) {
			// TODO Auto-generated method stub
			
			Boolean check=false;
			//get current session
			Session currentSession=sessionFactory.getCurrentSession();
			
			//query 
			Query theQuery=currentSession.createQuery("from UserTable as o where o.user_name=? and o.user_password=?");
			theQuery.setParameter(0, theUser.getUser_name());
			theQuery.setParameter(1, theUser.getUser_password());
			
			List list=theQuery.getResultList();
			
			if((list != null)&&(list.size()>0)) {
				check=true;
			}
			
			
			
			return check;
		}

		
		
		
		
		
		
	

}
