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

import com.ams.bean.FlightDetailsinfo;
import com.ams.entity.FlightDetails;
import com.ams.service.FlightDetailsService;

@RestController
@RequestMapping("/flightdetails")
public class FlightDetailsController {
	
	@Autowired
    FlightDetailsService flightDetailsService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	FlightDetails register(@RequestBody FlightDetailsinfo flightdetailsinfo) {
	  return flightDetailsService.register(flightdetailsinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	FlightDetails update(@RequestBody FlightDetailsinfo flightdetailsinfo) {
		
		return flightDetailsService.update(flightdetailsinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<FlightDetails> getAll(){
		
		return flightDetailsService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<FlightDetails> getById(@RequestParam("id") Long id){
		
		return flightDetailsService.getById(id);
	}
}

