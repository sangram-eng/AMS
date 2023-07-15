package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.FlightDetailsinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.FlightDetails;
import com.ams.entity.PassengerRegistration;
import com.ams.repository.FlightDetailsRepository;
import com.ams.repository.PassengerRegistrationRepository;

@Service
public class FlightDetailsService {

@Autowired
	
  FlightDetailsRepository FlightDetailsRepository;
	
	public FlightDetails register(FlightDetailsinfo flightdetailsinfo) {
		return FlightDetailsRepository.save(flightdetailsinfo.convertToEntity());
	}
	
	public FlightDetails update(FlightDetails flightdetails) {
		return FlightDetailsRepository.save(flightdetails);
	}
	
	public List<FlightDetails> getAll() {
		return FlightDetailsRepository.findAll();
	}
	
	public Optional<FlightDetails> getById(Long id) {
		return FlightDetailsRepository.findById(id);
		
	}

}
