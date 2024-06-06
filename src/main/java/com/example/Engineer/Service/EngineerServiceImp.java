package com.example.Engineer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.example.Engineer.Dto.EngineerDto;
import com.example.Engineer.entity.Engineer;

public interface EngineerServiceImp {

	Engineer create(Engineer engineer);
	
	Optional<Engineer> getdetails(int id);
	 
    List<Engineer> getall();

	Engineer update(Engineer engineer);

	String delete(int id);

	List<Engineer> createall(List<Engineer> engineerall);


	Optional<Engineer> getfilter(String name);

	List<Engineer> getallEngineer(String city);

	//DTO//
	
	EngineerDto getdto(int id);

	EngineerDto create(EngineerDto engineerdto);

	List<EngineerDto> getalldto(String role);

	








	









	



}
