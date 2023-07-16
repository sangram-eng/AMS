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

import com.ams.bean.Billinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.Bill;
import com.ams.entity.PassengerRegistration;
import com.ams.service.BillService;
import com.ams.service.PassengerRegistrationService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	BillService billService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Bill register(@RequestBody Billinfo billinfo) {
	  return billService.register(billinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	Bill update(@RequestBody Billinfo billinfo) {
		
		return billService.update(billinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<Bill> getAll(){
		
		return billService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<Bill> getById(@RequestParam("id") Long id){
		
		return billService.getById(id);
	}
}

