package com.saran.spring.restful.restfulweb201.entity;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="User Details", description="User entity Description")
public class User {
	private int id;

	
	@Size(min=2, message="Name should be at least 2 characters")
	@NotBlank(message="Name should not be empty")
	@ApiModelProperty("Name should not be empty, and it must be of at least 2 characters")
	private String name;

	@Past (message="BirthDate must be a past date")
	@ApiModelProperty ("BirthDate must be a past date")
	private Date birthDate;

	
//	protected User() {
//		super();
//		// TODO Auto-generated constructor stub
//	}

	public User(int id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


}
