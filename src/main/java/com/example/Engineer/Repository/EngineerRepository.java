package com.example.Engineer.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Engineer.entity.Engineer;

public interface EngineerRepository extends JpaRepository<Engineer, Integer>{
  
// @Query(value="select name,city,role from studentdata.engineer where name=John")

	 Optional<Engineer> findByName(String name);

	List<Engineer> findByCity(String city);

	

//	Engineer findbyName(String name);

//	Optional<Engineer> findbyEngineerName(String name);
    
	
	
}
