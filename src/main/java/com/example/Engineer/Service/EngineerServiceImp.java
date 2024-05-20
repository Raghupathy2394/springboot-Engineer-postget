package com.example.Engineer.Service;

import java.util.List;
import java.util.Optional;

import com.example.Engineer.entity.Engineer;

public interface EngineerServiceImp {

	Engineer create(Engineer engineer);
	
	Optional<Engineer> getdetails(int id);
	 
    List<Engineer> getall();

	Engineer update(Engineer engineer);

	String delete(int id);

	List<Engineer> createall(List<Engineer> engineerall);





	




	









	



}
