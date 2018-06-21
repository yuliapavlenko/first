package com.example.demo.controller;

import com.example.demo.dao.entities.Person;
import com.example.demo.dao.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class PersonController {
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping(value ="/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/all")
	public ResponseEntity<?> findAll(){
		return new ResponseEntity<List<Person>>(personRepository.findAll(), HttpStatus.OK);
	}
}
