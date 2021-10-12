package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User implements Serializable{
	@Id
	@Column(name = "username", length = 50)
	private String username;
	@Column(name = "password", length = 50)
	private String password;
	@Column(name = "fullname", length = 50)
	private String fullname;
	@Column(name = "age", length = 50)
	private Integer age;
	@Column(name = "gender", length = 50)
	private boolean gender;
	
	
}
