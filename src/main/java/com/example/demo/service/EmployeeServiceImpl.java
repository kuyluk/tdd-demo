package com.example.demo.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.controller.model.EmployeesDTO;
import com.example.demo.controller.model.ProjectDTO;
import com.example.demo.controller.model.SalaryDTO;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employees;
import com.example.demo.model.Project;

@Service("empSvc")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;

	
	/* (non-Javadoc)
	 * @see com.example.demo.service.EmployeeService#retrieveAllEmployess()
	 */
	@Override
	@Transactional
	public List<Employees> retrieveAllEmployess(){
		
		return dao.retrieveAllEmployess();
	}
	
	
	
	@Transactional
	@Override
	public EmployeesDTO findById(Integer id) {
		
		Employees emp = dao.findById(id);
		
		EmployeesDTO dto = EmployeesDTO.builder()
										.withBirthDate(emp.getBirthDate())
										.withEmpNo(emp.getEmpNo())
										.withFirstName(emp.getFirstName())
										.build();
		
		List<SalaryDTO> salaries = emp.getSalariesEmployeesViaEmpNo().stream()
																	.map(e -> {
																		return SalaryDTO.builder()
																						.withEmpNo(e.getSalariesId().getEmpNo())
																						.withFromDate(e.getFromDate())
																						.withSalary(e.getSalary())
																						.build();
																	}).collect(Collectors.toList());
		//Comparator<SalaryDTO> comparator = 
		salaries = salaries.stream()
							.sorted(comparatorByDate())
							.collect(Collectors.toList());
		dto.setSalaries(salaries);

		return dto;
	}
	
	@Override
	public List<EmployeesDTO> retriveAllEmployees(){
		
		List<Employees> employees = dao.retrieveAllEmployess();
		
		List<EmployeesDTO> dtos = employees.stream().map(e -> convertToDto(e)).collect(Collectors.toList());
		
		return dtos;
	}
	
	@Override
	public List<EmployeesDTO> retriveEmployeesByProject(String projectName){
		
		List<Employees> employees = dao.findByProjectName(projectName);
		
		List<EmployeesDTO> dtos = employees.stream().map(e -> convertToDto(e)).collect(Collectors.toList());
		
		return dtos;
		
	}
	
	private EmployeesDTO convertToDto(Employees emp) {

		EmployeesDTO dto = EmployeesDTO.builder().withBirthDate(emp.getBirthDate()).withEmpNo(emp.getEmpNo())
				.withFirstName(emp.getFirstName()).build();
		
		List<ProjectDTO> projects = emp.getProjects().stream().map(p -> {
			return ProjectDTO.builder().withId(p.getId()).withName(p.getName()).build();
		}).collect(Collectors.toList());
		
		dto.setProjects(projects);
		
		

//		List<SalaryDTO> salaries = emp.getSalariesEmployeesViaEmpNo().stream().map(e -> {
//			return SalaryDTO.builder().withEmpNo(e.getSalariesId().getEmpNo()).withFromDate(e.getFromDate())
//					.withSalary(e.getSalary()).build();
//		}).collect(Collectors.toList());
		
		
		
		
		
		//salaries = salaries.stream().sorted(comparatorByDate()).collect(Collectors.toList());
		//dto.setSalaries(salaries);
		return dto;
	}
	
	private Comparator<SalaryDTO> comparatorByDate(){
		return (s1, s2) -> {
			return s1.getFromDate().compareTo(s2.getFromDate());
		};
	}

	@Override
	@Transactional(readOnly=false)
	public void createEmployee(EmployeesDTO dto) {
		Employees emp = dao.findById(10932);
		//emp.setFirstName("Murat");
		Project project = new Project();
		project.setEmployee(emp);
		project.setName("Pro-1");
	
		emp.addProjects(project);
		
		dao.save(emp);
		
	}
}
