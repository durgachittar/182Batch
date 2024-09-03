package com.tka.WorkSphere.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.WorkSphere.DAO.CompanyDAO;
import com.tka.WorkSphere.Entity.Company;

@Service
public class CompanyService {
	@Autowired  
	CompanyDAO dao;
	public  String save(Company c) {
		
			
			String str=dao.save(c);
			if(Objects.isNull(str))
			{
				str="Country not added";
			}
			return str;
	
	}
	public String update(int id, Company c) {
		// TODO Auto-generated method stub
		String str=dao.update(id,c);
		if(Objects.isNull(str))
		{
			str="Country not Updated";
		}
		return str;
	}

}
