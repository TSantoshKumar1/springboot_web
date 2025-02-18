package com.spring_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_web.Service.EmailService;
import com.spring_web.Service.RegistrationService;
import com.spring_web.entity.Registration;
import com.spring_web.entity.RegistrationDto;

@Controller
public class RegistrationController {
	
	@Autowired
	private  RegistrationService registrationService;
	
	@Autowired
	private  EmailService emailservice ;
	
	
	@RequestMapping("/newReg")
	public String home() {
		
		return "new_registration";
	}
	
	
	
	
	
	@RequestMapping("/saveReg")
	public String saveRegistration(@ModelAttribute Registration registration , ModelMap model) {
		
		
		registrationService.createRegistration(registration);
		
		// for sending message to email.....
		 emailservice.sendEmail(registration.getEmail(), "Test", "welcome Message");
		
		model.addAttribute("msg", "Record is saved!");
		
		return "new_registration";
	}

	

//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//			@RequestParam("firstname") String firstname ,
//			@RequestParam("lastname") String lastname , 
//			@RequestParam("email") String email ,
//			@RequestParam("mobile") long mobile 
//			)
//		
//	{
	
//		 Registration registration =  new Registration();
//		 registration.setFirstname(firstname);
//		 registration.setLastname(lastname);
//		 registration.setEmail(email);
//		 registration.setMobile(mobile);
//		 
//		registrationService.createRegistration(registration);
//		
//		return "new_registration";
//	}
	
	@RequestMapping("/all-Reg")
	public String getAllRegistration(Model model) {
		
		List<Registration> reg = registrationService.getallRegistration();
		model.addAttribute("allregistrations",reg );
		
		return "allRegistration";
	}
	
	
	@RequestMapping("/delete-registration")
	public String deleteRegistration(@RequestParam("id") int id , Model model) {
		
		registrationService.deleteRegistration(id);
		
		List<Registration> reg = registrationService.getallRegistration();
		model.addAttribute("allregistrations",reg );

		
		return "allRegistration";
	}
	
	
	@RequestMapping("/update-Registration")
	public String updateRegistration(@RequestParam int id , Model model) {
		
		 Registration registration = registrationService.getRegistrationById(id);
		 model.addAttribute("registration", registration);
		
		
		return "update_Registration";
	}
	
	
	@RequestMapping("/updateRegRecord")
	public String updateRegRecord(RegistrationDto dto , Model model) {
		
		  Registration registration = new Registration();
		  registration.setId(dto.getId());
		  registration.setFirstname(dto.getFirstname());
		  registration.setLastname(dto.getLastname());
		  registration.setEmail(dto.getEmail());
		  registration.setMobile(dto.getMobile());
		
		 registrationService.updateRegRecord(registration);
		 
		 List<Registration> getallRegistration = registrationService.getallRegistration();
		 
		 model.addAttribute("allregistrations", getallRegistration);
		
		return "allRegistration";
	}
	
}
