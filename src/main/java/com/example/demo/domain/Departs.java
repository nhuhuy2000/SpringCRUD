package com.example.demo.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departs")
public class Departs implements Serializable{
	@Id
	@Column(length = 10)
	private String id;
	@Column(length = 50)
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departs")
	private Set<Staffs> staffs;
}
