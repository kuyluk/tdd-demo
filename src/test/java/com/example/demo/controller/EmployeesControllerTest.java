package com.example.demo.controller;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.controller.model.EmployeesDTO;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class EmployeesControllerTest {

	private MockMvc mockMvc;
	
	@Mock
	private EmployeeService employeesService;
	
	@InjectMocks
	private EmployeesController controller;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void test() throws Exception {
		EmployeesDTO dto = EmployeesDTO.builder()
										.withFirstName("Murat")
										.withEmpNo(Integer.valueOf(12))
										.build();
		
		when(employeesService.retriveAllEmployees()).thenReturn(Arrays.asList(dto));
		
		mockMvc.perform(get("/employees"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(jsonPath("$", hasSize(1)));
		verify(employeesService, times(1)).retriveAllEmployees();
	}
}
