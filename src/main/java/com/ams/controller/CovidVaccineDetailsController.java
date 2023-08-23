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

import com.ams.bean.CovidVaccineDetailsinfo;
import com.ams.entity.CovidVaccineDetails;
import com.ams.service.CovidVaccineDetailsService;

@RestController
@RequestMapping("/covidvaccinedetails")

public class CovidVaccineDetailsController {
	@Autowired
	CovidVaccineDetailsService covidvaccinedetailsService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	CovidVaccineDetails register(@RequestBody CovidVaccineDetailsinfo covidvaccinedetailsinfo) {
	  return covidvaccinedetailsService.register(covidvaccinedetailsinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	CovidVaccineDetails update(@RequestBody CovidVaccineDetailsinfo covidvaccinedetailsinfo) {
		
		return covidvaccinedetailsService.update(covidvaccinedetailsinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<CovidVaccineDetails> getAll(){
		
		return covidvaccinedetailsService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<CovidVaccineDetails> getById(@RequestParam("id") Long id){
		
		return covidvaccinedetailsService.getById(id);
	}
}



