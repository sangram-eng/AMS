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

import com.ams.bean.Cancellationinfo;
import com.ams.entity.Cancellation;
import com.ams.service.CancellationService;


@RestController
@RequestMapping("/cancellation")
public class CancellationController {
	
	@Autowired
	CancellationService cancellationService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Cancellation register(@RequestBody Cancellationinfo cancellationinfo) {
	  return cancellationService.register(cancellationinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	Cancellation update(@RequestBody Cancellationinfo cancellationinfo) {
		
		return cancellationService.update(cancellationinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<Cancellation> getAll(){
		
		return cancellationService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<Cancellation> getById(@RequestParam("id") Long id){
		
		return cancellationService.getById(id);
	}
}
