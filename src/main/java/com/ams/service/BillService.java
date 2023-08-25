package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.Billinfo;
import com.ams.entity.Bill;
import com.ams.repository.BillRepository;
import com.ams.business.exception.BusinessExeption;

@Service

public class BillService {

@Autowired
	
    BillRepository BillRepository;
	
	public Bill register(Billinfo billinfo) {
		try
		{
			if(billinfo.getUserName().isEmpty()||billinfo.getUserName().length()==0)
			{
				throw new BusinessExeption("601","Please send proper name, It blank");
			}
			return BillRepository.save(billinfo.convertToEntity());
			
		}catch(IllegalArgumentException e) {
			throw new BusinessExeption("602","givien empolyee is null"+e.getMessage());
		}
		catch(Exception e) {
			throw new BusinessExeption("603","Something went worng in service layer while saving the employee"+e.getMessage());
		}
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



