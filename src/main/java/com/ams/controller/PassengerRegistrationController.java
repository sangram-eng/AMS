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

import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.exception.UserNotFoundException;
import com.ams.repository.PassengerRegistrationRepository;
import com.ams.service.PassengerRegistrationService;


@RestController
@RequestMapping("/api/v1/passenger")
public class PassengerRegistrationController {
	
	@Autowired
	PassengerRegistrationService passengerRegistrationService;
	@Autowired
	PassengerRegistrationRepository passengerRegRepo;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	PassengerRegistration register(@RequestBody PassengerRegistrationinfo passengerRegistrationInfo) {
		return passengerRegistrationService.register(passengerRegistrationInfo);		
	}
	 @PutMapping("/edit/{id}")
	 PassengerRegistration update(@RequestBody PassengerRegistration newUser, @PathVariable Long id) {
	        return passengerRegRepo.findById(id)
	                .map(user -> {
	                    user.setUserName(newUser.getUserName());
	                    user.setAge(newUser.getAge());
	                    user.setDob(newUser.getDob());
	                    user.setPhoneNo(newUser.getPhoneNo());
	                    user.setNationality(newUser.getNationality());
	                    user.setEmailId(newUser.getEmailId());
	                    user.setGender(newUser.getGender());
	                    user.setPassportNo(newUser.getPassportNo());
	                    user.setVaccineId(newUser.getVaccineId());
	                    user.setAddress(newUser.getAddress());
	                    return passengerRegRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<PassengerRegistration> getAll(){
		
		return passengerRegRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    PassengerRegistration getUserById(@PathVariable Long id) {
        return passengerRegRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!passengerRegRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        passengerRegRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }


}
