package com.spring_web.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_web.entity.Registration;
import com.spring_web.repostiory.RegistrationRepostiory;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	
	@Autowired
	private RegistrationRepostiory registrationRepostiory;
	
	
	
	// save the registration....
	
	@Override
	public void createRegistration(Registration registration) {
		
		registrationRepostiory.save(registration);
		
	}



	@Override
	public List<Registration> getallRegistration() {
		
		List<Registration> registrations = registrationRepostiory.findAll();
		
		
		return registrations;
	}


	

	@Override
	public void deleteRegistration(int id) {
		
		registrationRepostiory.deleteById(id);
		
	}



	@Override
	public Registration getRegistrationById(int id) {
		
		Registration registration = registrationRepostiory.findById(id).get();
		
		return registration ;
	}



	@Override
	public void updateRegRecord(Registration registration) {
	
		registrationRepostiory.save(registration);
		
	}







	

}
