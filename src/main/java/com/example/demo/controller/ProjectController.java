package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.model.Project;
import com.example.demo.service.ProjectService;

@RestController
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="/projects", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<Project>> retrieveAllProjects() {
		
		return new ResponseEntity<List<Project>>(projectService.retrieveAllProjects(), HttpStatus.OK);
	}

	@RequestMapping(value="/projects/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Project> retrieveProjectById(@PathVariable Integer id){
		
		return new ResponseEntity<Project>(projectService.retrieveProjectById(id), HttpStatus.OK);
	}
}
