package com.spring_web.Service;

import java.util.List;

import com.spring_web.entity.Registration;



public interface RegistrationService {

	public void createRegistration(Registration registration);
	
	public List<Registration> getallRegistration();

	public void deleteRegistration(int id);

	public Registration getRegistrationById(int id);

	public void updateRegRecord(Registration registration);

	
	
	
}
