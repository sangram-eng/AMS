package com.ams.bean;

import com.ams.entity.PassengerRegistration;
import com.ams.entity.User;
import lombok.Data;

@Data
public class PassengerRegistrationinfo {

    private String id;
    private String passengerName;
    private Long userId;  // ✅ Accept userId instead of full User
    private String age;
    private String dob;
    private String phoneNo;
    private String nationality;
    private String emailId;
    private String gender;
    private String passportNo;
    private String address;
    private String vaccineId;

    public PassengerRegistration convertToEntity(User user) {
        PassengerRegistration passenger = new PassengerRegistration();

        if (id != null && !id.equals("0")) {
            passenger.setId(Long.valueOf(id));
        }

        passenger.setPassengerName(passengerName);
        passenger.setUser(user);  // ✅ Set full User entity here
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
