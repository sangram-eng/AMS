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

import com.ams.bean.BookTicketinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.BookTicket;
import com.ams.entity.PassengerRegistration;
import com.ams.service.BookTicketService;
import com.ams.service.PassengerRegistrationService;

@RestController
@RequestMapping("/bookticket")
public class BookTicketController {
	
	@Autowired
	BookTicketService bookticketService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	BookTicket register(@RequestBody BookTicketinfo bookticketinfo) {
	  return bookticketService.register(bookticketinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	BookTicket update(@RequestBody BookTicketinfo bookticketinfo) {
		
		return bookticketService.update(bookticketinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<BookTicket> getAll(){
		
		return bookticketService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<BookTicket> getById(@RequestParam("id") Long id){
		
		return bookticketService.getById(id);
	}
}



