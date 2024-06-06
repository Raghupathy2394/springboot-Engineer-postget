package com.example.Engineer.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

import com.example.Engineer.Dto.EngineerDto;
import com.example.Engineer.Repository.EngineerRepository;
import com.example.Engineer.entity.Engineer;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class EngineerService implements EngineerServiceImp {

	@Autowired
	EngineerRepository engineerRepo;

	@Override
	public Engineer create(Engineer engineer) {
		return engineerRepo.save(engineer);
	}

	@Override
	public Optional<Engineer> getdetails(int id) {
		return engineerRepo.findById(id);
	}

	@Override
	public List<Engineer> getall() {
		return engineerRepo.findAll();
	}

	@Override
	public Engineer update(Engineer engineer) {
		Optional<Engineer> engineer1 = engineerRepo.findById(engineer.getId());
		Engineer engineer2 = engineer1.get();
		engineer2.setId(engineer.getId());
		engineer2.setName(engineer.getName());
		engineer2.setContact(engineer.getContact());
		engineer2.setSalary(engineer.getSalary());
		return engineerRepo.save(engineer2);
	}

	@Override
	public String delete(int id) {
		engineerRepo.deleteById(id);
		return "deleted";
	}

	@Override
	public List<Engineer> createall(List<Engineer> engineerall) {
		return engineerRepo.saveAll(engineerall);
	}

	@Override
	public Optional<Engineer> getfilter(String name) {
		return engineerRepo.findByName(name);
	}

	// get all engineers and one variable using string
	@Override
	public List<Engineer> getallEngineer(String city) {
		if(city==null) {
			return engineerRepo.findAll();
		} else
			return engineerRepo.findByCity(city);
	}


	// DTO //
	
	@Override
	public EngineerDto getdto(int id) {
		Optional<Engineer> engineer=engineerRepo.findById(id);
		Engineer engineer1=engineer.get();
		EngineerDto dto=new EngineerDto();
		dto.setId(engineer1.getId());
		dto.setCity(engineer1.getCity());
		dto.setContact(engineer1.getContact());
		dto.setName(engineer1.getName());
		dto.setRole(engineer1.getRole());
		dto.setSalary(engineer1.getSalary());
		return dto;
	}

	@Override
	public EngineerDto create(EngineerDto engineerdto) {
		Engineer engineer=new Engineer();
		engineer.setCity(engineerdto.getCity());
		engineer.setContact(engineerdto.getContact());
		engineer.setName(engineerdto.getName());
		engineer.setRole(engineerdto.getRole());
		engineer.setSalary(engineerdto.getSalary());
		 engineerRepo.save(engineer);
		 return engineerdto;
	}

	@Override
	public List<EngineerDto> getalldto(String role) {
  List<Engineer> engineer=engineerRepo.findAll();
  List<EngineerDto> dto=new ArrayList<>();
for(Engineer e:engineer) {
	  EngineerDto engdto=new  EngineerDto();
	  engdto.setId(e.getId());
	  engdto.setCity(e.getCity());
	  engdto.setContact(e.getContact());
	  engdto.setName(e.getName());
	  engdto.setRole(e.getRole());
	  engdto.setSalary(e.getSalary());
      dto.add(engdto);
}	return dto;
	}
	
	}


