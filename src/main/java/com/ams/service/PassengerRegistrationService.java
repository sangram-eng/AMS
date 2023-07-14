package com.ams.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.repository.PassengerRegistrationRepository;

@Service
public class PassengerRegistrationService {

@Autowired
	
PassengerRegistrationRepository PassengerRegistrationRepository;
	
	public PassengerRegistration register(PassengerRegistrationinfo passengerregistrationinfo) {
		return PassengerRegistrationRepository.save(passengerregistrationinfo.convertToEntity());
	}
	
	public PassengerRegistration update(PassengerRegistration passengerregistration) {
		return PassengerRegistrationRepository.save(passengerregistration);
	}
	
	public List<PassengerRegistration> getAll() {
		return PassengerRegistrationRepository.findAll();
	}
	
	public Optional<PassengerRegistration> getById(Long id) {
		return PassengerRegistrationRepository.findById(id);
		
	}
}
