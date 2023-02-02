package com.codedecode.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codedecode.demo.entity.Employee;
import com.codedecode.demo.respository.EmployeeRepository;

@RestController
@RequestMapping("/code")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping
	public List<Employee> getAllEmployee(){
		System.out.println("getting all employee");
		return employeeRepository.findAll();
	}
}
