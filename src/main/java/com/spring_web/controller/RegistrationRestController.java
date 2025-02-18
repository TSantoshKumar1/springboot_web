package com.spring_web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_web.entity.Registration;
import com.spring_web.entity.RegistrationDto;
import com.spring_web.repostiory.RegistrationRepostiory;

@RestController
@RequestMapping("/api/reg")
public class RegistrationRestController {
	
	@Autowired
	private RegistrationRepostiory registrationRepostiory;
	

// getting the Registrations.........	
	
	// http://locahost:8082/api/reg
	@GetMapping
	public List<Registration> getAllRegistration() {
		
		List<Registration> allregistration = registrationRepostiory.findAll();	
		
		return allregistration;
	}
	
	
	
	
	
	
	
// creating the Registration.....	
	
	@PostMapping
	public ResponseEntity<?> createRegistration(@RequestBody Registration registration) {
		
		Registration savedregistration = registrationRepostiory.save(registration);
		return new ResponseEntity<>(savedregistration, HttpStatus.CREATED);
	}
	
	
	
	
// deleting the Registration..........
	
	
	
//	http://locahost:8082/api/reg/12
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRegistration(@PathVariable int id){
		registrationRepostiory.deleteById(id);
		
		return new ResponseEntity<>("Deleted !!", HttpStatus.OK);
	}
	
	
	
//  update the Registration...........
	
//  http://locahost:8082/api/reg?1d=10

	@PutMapping
	public ResponseEntity<Registration> updateRegistration( @RequestParam int id , @RequestBody RegistrationDto dto){
		
		 Registration registration = registrationRepostiory.findById(id).get();
		 
		 registration.setFirstname(dto.getFirstname());
		 registration.setLastname(dto.getLastname());
		 registration.setEmail(dto.getEmail());
		 registration.setMobile(dto.getMobile());
		 
		 Registration saveregistration = registrationRepostiory.save(registration);
		 
		return new ResponseEntity<>( saveregistration, HttpStatus.OK);
				
		
	}
	
	
	
	
//	http://locahost:8082/api/reg/10
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getRegistrationByid(@PathVariable int id){
		
		try {
			
		
		Optional<Registration> byId = registrationRepostiory.findById(id);
		Registration registration = byId.get();
	
		return new ResponseEntity<>(registration , HttpStatus.INTERNAL_SERVER_ERROR);
	   
		}catch(Exception e) {
			
			return new ResponseEntity<>("Registration not found with id:"+ id, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	
	}
	
}
