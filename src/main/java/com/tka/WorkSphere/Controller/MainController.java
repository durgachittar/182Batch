package com.tka.WorkSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.tka.WorkSphere.Entity.Company;
import com.tka.WorkSphere.Service.CompanyService;

@RestController
@RequestMapping("api")

public class MainController {
	
	@Autowired
	CompanyService service;
	
	
	//POST...localhost:8081/api/AddRecord..BODY...RAW...JSON...{"cname":"INDIA"}
	@PostMapping("AddRecord")
	public String save(@RequestBody Company c)
	{
		String str=service.save(c);
		return str;
	}

	//PUT...localhost:8081/api/UpdateRecord/1.....BODY...RAW...JSON...{"cname":"USA"}
	@PutMapping("UpdateRecord/{id}")
	public String update(@PathVariable int id,@RequestBody Company c)
	{
		String str=service.update(id,c);
		return str;
	}
}
