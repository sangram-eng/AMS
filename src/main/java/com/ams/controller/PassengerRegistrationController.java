package com.ams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.service.PassengerRegistrationService;

@RestController
@RequestMapping("/passengerRegistration")
public class PassengerRegistrationController {
	
	@Autowired
	PassengerRegistrationService passengerRegistrationService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	PassengerRegistration register(@RequestBody PassengerRegistrationinfo passengerRegistrationinfo) {
	  return passengerRegistrationService.register(passengerRegistrationinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	PassengerRegistration update(@RequestBody PassengerRegistrationinfo passengerRegistrationinfo) {
		
		return passengerRegistrationService.update(passengerRegistrationinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<PassengerRegistration> getAll(){
		
		return passengerRegistrationService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<PassengerRegistration> getById(@RequestParam("id") Long id){
		
		return passengerRegistrationService.getById(id);
	}
}
