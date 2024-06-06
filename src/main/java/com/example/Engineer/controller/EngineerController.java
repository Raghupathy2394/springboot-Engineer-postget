package com.example.Engineer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Engineer.Dto.EngineerDto;
import com.example.Engineer.Service.EngineerServiceImp;
import com.example.Engineer.entity.Engineer;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/engineer")
public class EngineerController {
	@Autowired
	EngineerServiceImp engineerService;

	@PostMapping("/create")
	public Engineer create(@RequestBody Engineer engineer) {
		return engineerService.create(engineer);
	}

	@PostMapping("/createall")
	public List<Engineer> createall(@RequestBody List<Engineer> engineerall) {
		return engineerService.createall(engineerall);
	}

	@GetMapping("/get/{id}")
	public Optional<Engineer> getdetails(@PathVariable int id) {
		Optional<Engineer> engineer = engineerService.getdetails(id);
		return engineer;
		// public Optional<Engineer> getdetails(@PathVariable int id) {
		// return engineerService.getdetails(id);
	}

	@GetMapping("/getdetails")
	public List<Engineer> getall() {
		return engineerService.getall();
	}

	@PutMapping("/update")
	public Engineer update(@RequestBody Engineer engineer) {
		return engineerService.update(engineer);
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return engineerService.delete(id);
	}

	/// Get all engineers and one string value

	@GetMapping("/getallengineers")
	public List<Engineer> getallEngineer(@RequestParam(value = "city", required = false) String city) {
		return engineerService.getallEngineer(city);
	}

	@GetMapping("/getfilter/{name}")
	public Optional<Engineer> getfilter(@PathVariable String name) {
		Optional<Engineer> engineer = engineerService.getfilter(name);
		return engineer;
	}
	
	// DTO ///
	
	@GetMapping("/getdtoengineer/{id}")
	public EngineerDto getdto(@PathVariable int id) {
		return engineerService.getdto(id);
	}
	
	@GetMapping("/getalldto")
	public List<EngineerDto> getalldto(@RequestParam (value="role", required=false) String role){
		return engineerService.getalldto(role);
	}
	
	@PostMapping("/postdto")
public EngineerDto createDto(@RequestBody EngineerDto engineerdto) {
		return engineerService.create(engineerdto);
	
}
	
	
	
	
	
	
	
	
	
}