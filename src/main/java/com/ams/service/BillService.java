package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.Billinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.Bill;
import com.ams.entity.PassengerRegistration;
import com.ams.repository.BillRepository;
import com.ams.repository.PassengerRegistrationRepository;

@Service

public class BillService {

@Autowired
	
    BillRepository BillRepository;
	
	public Bill register(Billinfo billinfo) {
		return BillRepository.save(billinfo.convertToEntity());
	}
	
	public Bill update(Bill bill) {
		return BillRepository.save(bill);
	}
	
	public List<Bill> getAll() {
		return BillRepository.findAll();
	}
	
	public Optional<Bill> getById(Long id) {
		return BillRepository.findById(id);
		
	}
}



