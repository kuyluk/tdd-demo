package com.example.demo.controller.model;

import java.util.Date;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SalaryDTO {

	private Integer empNo;
	
	private Integer salary;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date fromDate;

	@Generated("SparkTools")
	private SalaryDTO(Builder builder) {
		this.empNo = builder.empNo;
		this.salary = builder.salary;
		this.fromDate = builder.fromDate;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Creates builder to build {@link SalaryDTO}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link SalaryDTO}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Integer empNo;
		private Integer salary;
		private Date fromDate;

		private Builder() {
		}

		public Builder withEmpNo(Integer empNo) {
			this.empNo = empNo;
			return this;
		}

		public Builder withSalary(Integer salary) {
			this.salary = salary;
			return this;
		}

		public Builder withFromDate(Date fromDate) {
			this.fromDate = fromDate;
			return this;
		}

		public SalaryDTO build() {
			return new SalaryDTO(this);
		}
	}
	
	
	
}
