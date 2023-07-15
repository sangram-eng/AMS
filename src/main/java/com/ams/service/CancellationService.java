package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.Cancellationinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.Cancellation;
import com.ams.entity.PassengerRegistration;
import com.ams.repository.CancellationRepository;
import com.ams.repository.PassengerRegistrationRepository;

@Service
public class CancellationService 
  {

@Autowired
	  
    CancellationRepository CancellationRepository;
	
	public Cancellation register(Cancellationinfo cancellationinfo) {
		return CancellationRepository.save(cancellationinfo.convertToEntity());
	}
	
	public Cancellation update(Cancellation cancellation) {
		return CancellationRepository.save(cancellation);
	}
	public List<Cancellation> getAll() {
		return CancellationRepository.findAll();
	}
	
	public Optional<Cancellation> getById(Long id) {
		return CancellationRepository.findById(id);
		
	}

}
