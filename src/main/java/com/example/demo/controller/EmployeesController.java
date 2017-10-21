package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.EmployeesDTO;
import com.example.demo.model.Employees;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeesController {
	
	@Autowired
	@Qualifier("empSvc")
	private EmployeeService employeeService;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity retrieveEmployees() {
		
		List<EmployeesDTO> emps = employeeService.retriveAllEmployees();
		
		
		return new ResponseEntity(emps, HttpStatus.OK);
	}
	
	@RequestMapping(value="/employees/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity retrieveEmployeeById(@PathVariable Integer id) {
		
		return new ResponseEntity(employeeService.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity createEmployee() {
		employeeService.createEmployee(null);
		return new ResponseEntity("", HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/employees/projects/{projectName}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity retrieveEmployeesByProjectName(@PathVariable String projectName) {
		List<EmployeesDTO> dtos = employeeService.retriveEmployeesByProject(projectName);
		return new ResponseEntity(dtos, HttpStatus.OK);
	}

}
