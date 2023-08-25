package com.ams.bean;

import com.ams.entity.PassengerRegistration;
import lombok.Data;

@Data
public class PassengerRegistrationinfo {
	private String id;
	private String userName;
	private String age;
	private String dob;
	private String phoneNo;
	private String nationality;
	private String emailId;
	private String gender;
	private String passportNo;
	private String address;
	private String vaccineId;
	
	public PassengerRegistration convertToEntity() {
		
		PassengerRegistration passenger= new PassengerRegistration();
			if(id!=null  && id!="0")			
		    passenger.setId(Long.valueOf(id));
			passenger.setUserName(userName);
			passenger.setAge(age);
			passenger.setDob(dob);
			passenger.setPhoneNo(phoneNo);
			passenger.setNationality(nationality);
			passenger.setEmailId(emailId);
			passenger.setGender(gender);
			passenger.setPassportNo(passportNo);
			passenger.setAddress(address);
			passenger.setVaccineId(vaccineId);
			return passenger;
			
			
	}
	
}