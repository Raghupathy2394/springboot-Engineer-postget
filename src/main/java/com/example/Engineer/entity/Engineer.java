package com.example.Engineer.entity;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Engineers")
@Data
public class Engineer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;
	@Column(name = "salary")
	private int salary;
	@Column(name = "contact")
	private long contact;
	@Column(name = "role")
	private String role;
	@Column(name = "city")
	private String city;
	@Column(name = "gender")
	private String gender;
	@Column(name = "experience")
	private String experience;
}
