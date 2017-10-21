package com.example.demo.controller;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.model.Project;
import com.example.demo.service.ProjectService;


public class ProjectControllerTest {
	
	@Mock
	private ProjectService projectService;
	
	@InjectMocks
	private ProjectController projectController;
	
	MockMvc mockMvc;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	}
	
	@Test
	public void shouldRetrieveAllProjects() throws Exception {
		
		when(projectService.retrieveAllProjects()).thenReturn(Arrays.asList(new Project(1, "Pro-1")));
		
		mockMvc.perform(get("/projects"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", is("Pro-1")));
		
		verify(projectService, times(1)).retrieveAllProjects();
	}
	
	@Test
	public void shouldRetrieveProjectForValidId() throws Exception {
		
		mockMvc.perform(get("/projects/{id}", 1))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()));
				//.andExpect(jsonPath("$.id", is(1)))
				//.andExpect(jsonPath("$.name", is("Pro-1")));
	}

}
