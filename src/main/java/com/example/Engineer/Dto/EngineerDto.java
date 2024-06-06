package com.example.Engineer.Dto;

import com.example.Engineer.entity.Engineer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Engineer")
@Data
public class EngineerDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private int salary;
	@Column(name = "contact")
	private long contact;
	@Column(name = "role")
	private String role;
	@Column(name = "city")
	private String city;

}
