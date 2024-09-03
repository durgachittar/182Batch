package com.tka.WorkSphere.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DatabaseDemo.entity.Person;
import com.tka.WorkSphere.Entity.Company;

@Repository
public class CompanyDAO {
	@Autowired
	SessionFactory factory;

	public String save(Company c) {
		String msg=null;
		Session s=null;
		Transaction tx=null;
		try
		{
			s=factory.openSession();
			tx=s.beginTransaction();
			s.persist(c);
			tx.commit();
			msg="Country added";
			
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
		}
		finally {
			if(s!=null)
			{
				s.close();
			}
		}		
		return msg;
		}

	public String update(int id, Company c) {
		
		String msg=null;
		Session s=null;
		Transaction tx=null;
		try
		{
			// TODO Auto-generated method stub
			s=factory.openSession();
			tx=s.beginTransaction();
			Company c1=s.get(Company.class,id);
			c1.setCname(c.getCname());
			s.merge(c1);
			tx.commit();
			msg="Record Updated";
			
		}
		catch(Exception e)
		{
			if(tx!=null)
			{
				e.printStackTrace();
				tx.rollback();
			}
		}
		finally {
			if(s!=null)
			{
				s.close();
			}
		}
		return msg;
		}
	
	

}
