package com.example.demo.service;

import java.util.List;

import com.example.demo.controller.model.Project;

public interface ProjectService {
	
	public List<Project> retrieveAllProjects();
	
	public Project retrieveProjectById(Integer id);

}
