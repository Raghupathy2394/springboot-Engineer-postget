package com.example.Engineer.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
		return engineerepository.findAll();
	}

	@Override
	public Engineer update(Engineer engineer) {
		Optional<Engineer> engineer1 = engineerepository.findById(engineer.getId());
		Engineer engineer2 = engineer1.get();
		engineer2.setId(engineer.getId());
		engineer2.setName(engineer.getName());
		engineer2.setContact(engineer.getContact());
		engineer2.setSalary(engineer.getSalary());
		return engineerepository.save(engineer2);
	}

	@Override
	public String delete(int id) {
		engineerepository.deleteById(id);
		return "deleted";
	}

	@Override
	public List<Engineer> createall(List<Engineer> engineerall) {
		return engineerepository.saveAll(engineerall);
	}

}
