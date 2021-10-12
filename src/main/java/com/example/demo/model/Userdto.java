package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userdto implements Serializable{
	
	private String username;
	@NotEmpty
	@Min(value = 50)
	private String password;
	@NotEmpty
	@Min(value = 50)
	private String fullname;
	@NotEmpty
	@Min(value = 50)
	private Integer age;
	@NotEmpty
	@Min(value = 50)
	private boolean gender;
	private Boolean isEdit = false;
}
