package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.model.EmployeesDTO;
import com.example.demo.model.Employees;

public interface EmployeeService {

	List<Employees> retrieveAllEmployess();

	public EmployeesDTO findById(Integer id);
	
	public void createEmployee(EmployeesDTO dto);

	List<EmployeesDTO> retriveEmployeesByProject(String projectName);

	List<EmployeesDTO> retriveAllEmployees();
}