package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "staffs")
public class Staffs implements Serializable{
	@Id
	@Column(length = 10)
	private String id;
	@Column(length = 50)
	private String name;
	
	private boolean gender;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date birthday;
	@Column(length = 500)
	private String photo;
	
	@Column(length = 100)
	private String email;
	@Column(length = 12)
	private String phone;
	
	private Float salary;
	@Column(length = 500)
	private String notes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "departId")
	private Departs departs;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "staffs")
	private Set<Records> records;
}
