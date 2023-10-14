package com.ams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ams.bean.Billinfo;
import com.ams.entity.Bill;
import com.ams.service.BillService;
@RestController
@RequestMapping("/api/v1/bill")
public class BillController {
	
	@Autowired
	BillService billService;
	
	 @PostMapping("/register")
	 public ResponseEntity<?> addBill(@RequestBody Billinfo bill){
		Bill billregister = billService.register(bill);
		return new ResponseEntity<Bill>(billregister, HttpStatus.CREATED);
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

