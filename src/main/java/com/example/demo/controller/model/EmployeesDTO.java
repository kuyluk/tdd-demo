package com.example.demo.controller.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Collections;

public class EmployeesDTO {
	
	private Integer empNo;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String firstName;
	private String lastName;
	private String gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date hireDate;
	private List<SalaryDTO> salaries;
	private List<ProjectDTO> projects;



	@Generated("SparkTools")
	private EmployeesDTO(Builder builder) {
		this.empNo = builder.empNo;
		this.birthDate = builder.birthDate;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.gender = builder.gender;
		this.hireDate = builder.hireDate;
		this.salaries = builder.salaries;
		this.projects = builder.projects;
	}
	
	

	public List<SalaryDTO> getSalaries() {
		return salaries;
	}

	public List<ProjectDTO> getProjects() {
		return projects;
	}



	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}



	public void setSalaries(List<SalaryDTO> salaries) {
		this.salaries = salaries;
	}

	public EmployeesDTO() {
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	/**
	 * Creates builder to build {@link EmployeesDTO}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link EmployeesDTO}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Integer empNo;
		private Date birthDate;
		private String firstName;
		private String lastName;
		private String gender;
		private Date hireDate;
		private List<SalaryDTO> salaries = Collections.emptyList();
		private List<ProjectDTO> projects = Collections.emptyList();

		private Builder() {
		}

		public Builder withEmpNo(Integer empNo) {
			this.empNo = empNo;
			return this;
		}

		public Builder withBirthDate(Date birthDate) {
			this.birthDate = birthDate;
			return this;
		}

		public Builder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public Builder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public Builder withGender(String gender) {
			this.gender = gender;
			return this;
		}

		public Builder withHireDate(Date hireDate) {
			this.hireDate = hireDate;
			return this;
		}

		public Builder withSalaries(List<SalaryDTO> salaries) {
			this.salaries = salaries;
			return this;
		}

		public Builder withProjects(List<ProjectDTO> projects) {
			this.projects = projects;
			return this;
		}

		public EmployeesDTO build() {
			return new EmployeesDTO(this);
		}
	}
}