package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.PassengerRegistrationinfo;
import com.ams.bean.Refundinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.entity.Refund;
import com.ams.repository.PassengerRegistrationRepository;
import com.ams.repository.RefundRepository;

@Service
public class RefundService 
  {

@Autowired
	
    RefundRepository RefundRepository;
	
	public Refund register(Refundinfo refundinfo) {
		return RefundRepository.save(refundinfo.convertToEntity());
	}
	
	public Refund update(Refund refund) {
		return RefundRepository.save(refund);
	}
	
	public List<Refund> getAll() {
		return RefundRepository.findAll();
	}
	
	public Optional<Refund> getById(Long id) {
		return RefundRepository.findById(id);
		
	}

}
