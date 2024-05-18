package com.example.Engineer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Engineer.Repository.EngineerRepository;
import com.example.Engineer.entity.Engineer;

@Service
public class EngineerService implements EngineerServiceImp {

	@Autowired
	EngineerRepository engineerepository;

	@Override
	public Engineer create(Engineer engineer) {
		return engineerepository.save(engineer);
	}
	@Override
	public Optional<Engineer> getdetails(int id) {
		return engineerepository.findById(id);
	}
	@Override
	public List<Engineer> getall() {
		return  engineerepository.findAll();
	}
	
}
