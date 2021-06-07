package com.rajat.learning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rajat.learning.entities.Student;
import com.rajat.learning.repos.StudentRepository;

@Controller
public class ApplicationControllers {
	
	@Autowired
	StudentRepository srepo;
	
	@RequestMapping("/")
	public String home() {
		return "Home Page";
	}
	
	@PostMapping("/addStudent")
	public boolean addStudent(@RequestBody Student s1) {
		
		srepo.save(s1);
		return true;
		
	}

}
