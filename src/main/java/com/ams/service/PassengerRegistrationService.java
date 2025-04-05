package com.ams.service;

import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.PassengerRegistration;
import com.ams.entity.User;
import com.ams.repository.PassengerRegistrationRepository;
import com.ams.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerRegistrationService {

    private final PassengerRegistrationRepository passengerRepo;
    private final UserRepository userRepo;

    @Autowired
    public PassengerRegistrationService(PassengerRegistrationRepository passengerRepo,
                                        UserRepository userRepo) {
        this.passengerRepo = passengerRepo;
        this.userRepo = userRepo;
    }

    public PassengerRegistration userRegister(PassengerRegistrationinfo info) {
        User user = getUserById(info.getUserId());
        PassengerRegistration passenger = info.convertToEntity(user);
        return passengerRepo.save(passenger);
    }

    public PassengerRegistration adminRegister(PassengerRegistrationinfo info) {
        User user = getUserById(info.getUserId());
        PassengerRegistration passenger = info.convertToEntity(user);
        return passengerRepo.save(passenger);
    }

    public PassengerRegistration updateDetails(Long id, PassengerRegistration updated) {
        PassengerRegistration existing = passengerRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Passenger not found with ID: " + id));

        existing.setPassengerName(updated.getPassengerName());
        existing.setAge(updated.getAge());
        existing.setDob(updated.getDob());
        existing.setPhoneNo(updated.getPhoneNo());
        existing.setNationality(updated.getNationality());
        existing.setEmailId(updated.getEmailId());
        existing.setGender(updated.getGender());
        existing.setPassportNo(updated.getPassportNo());
        existing.setAddress(updated.getAddress());
        existing.setVaccineId(updated.getVaccineId());

        return passengerRepo.save(existing);
    }

    public List<PassengerRegistration> getAll() {
        return passengerRepo.findAll();
    }

    public List<PassengerRegistration> getByUser(User user) {
        return passengerRepo.findByUser(user);
    }

    public void deleteById(Long id) {
        if (!passengerRepo.existsById(id)) {
            throw new RuntimeException("Passenger not found with ID: " + id);
        }
        passengerRepo.deleteById(id);
    }

    private User getUserById(Long userId) {
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
    }
}
