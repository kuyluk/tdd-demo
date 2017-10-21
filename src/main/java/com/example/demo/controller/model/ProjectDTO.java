package com.example.demo.controller.model;

import javax.annotation.Generated;

public class ProjectDTO {

	private Integer id;
	private String name;

	@Generated("SparkTools")
	private ProjectDTO(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Creates builder to build {@link ProjectDTO}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ProjectDTO}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private Integer id;
		private String name;

		private Builder() {
		}

		public Builder withId(Integer id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public ProjectDTO build() {
			return new ProjectDTO(this);
		}
	}

}
