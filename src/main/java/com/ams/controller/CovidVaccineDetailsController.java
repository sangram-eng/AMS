package com.ams.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.bean.CovidVaccineDetailsinfo;
import com.ams.entity.CovidVaccineDetails;
import com.ams.exception.UserNotFoundException;
import com.ams.repository.CovidVaccineDetailsRepository;
import com.ams.service.CovidVaccineDetailsService;

@RestController
@RequestMapping("api/v1/covid")

public class CovidVaccineDetailsController {
	@Autowired
	CovidVaccineDetailsService covidvaccinedetailsService;
	@Autowired
	CovidVaccineDetailsRepository CovidVaccineDetailsRepository;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	CovidVaccineDetails register(@RequestBody CovidVaccineDetailsinfo passengerRegistrationInfo) {
		return covidvaccinedetailsService.register(passengerRegistrationInfo);		
	}
	 @PutMapping("/edit/{id}")
	 CovidVaccineDetails update(@RequestBody CovidVaccineDetails newUser, @PathVariable Long id) {
	        return CovidVaccineDetailsRepository.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setDob(newUser.getDob());
	                    user.setPhoneNo(newUser.getPhoneNo());
	                    user.setFirstVaccineDate(newUser.getFirstVaccineDate());
	                    user.setThirdVaccineDate(newUser.getThirdVaccineDate());
	                    user.setCertificateNo(newUser.getCertificateNo());
	                    return CovidVaccineDetailsRepository.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<CovidVaccineDetails> getAll(){
		
		return CovidVaccineDetailsRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    CovidVaccineDetails getUserById(@PathVariable Long id) {
        return CovidVaccineDetailsRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!CovidVaccineDetailsRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        CovidVaccineDetailsRepository.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}



