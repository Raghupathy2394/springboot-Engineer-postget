package com.example.Engineer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Engineer.Service.EngineerServiceImp;
import com.example.Engineer.entity.Engineer;

@RestController
@RequestMapping("/engineer")
public class EngineerController {
	@Autowired
   EngineerServiceImp engineerService;
	
	@PostMapping("/create")
	public Engineer create(@RequestBody Engineer engineer ) {
		return engineerService.create(engineer);
	}
	@GetMapping("/get/{id}")
	public Optional<Engineer> getdetails(@PathVariable int id) {
		 Optional<Engineer> engineer=engineerService.getdetails(id);
		 return engineer;
	//public Optional<Engineer> getdetails(@PathVariable int id) {
		//return engineerService.getdetails(id);
	} 
	
	@GetMapping("/getdetails")
	public List<Engineer> getall(){
		return engineerService.getall();
	}
	
}
