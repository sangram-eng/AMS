package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.FlightDetailsinfo;
import com.ams.entity.FlightDetails;
import com.ams.repository.FlightDetailsRepository;


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
