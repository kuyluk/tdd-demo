package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.example.demo.model.Employees;

@Component
public class EmployeeDAO {

	@PersistenceContext 
	private EntityManager em;
	
	
	public void save(Employees employee) {
		em.persist(employee);
		
	}
	
	public List<Employees> findByProjectName(String projectName){
		TypedQuery<Employees> query = em.createNamedQuery(Employees.FIND_BY_PROJECT_NAME, Employees.class);
		
		query.setParameter("projectName", projectName);
		
		
		List<Employees> employees = query.getResultList();
		
		return employees;
		
	}
	
	public Employees findById(Integer id) {
		return em.find(Employees.class, id);
	}
	
	public List<Employees> retrieveAllEmployess(){
		
		TypedQuery<Employees> query = em.createNamedQuery(Employees.FIND_ALL, Employees.class);
		
		int pageNumber = 1;
		int pageSize = 100;
		query.setMaxResults(pageSize);
		query.setFirstResult((pageNumber - 1) *  pageSize);
		List<Employees> employees = query.getResultList();
		
		return employees;
	}
}
