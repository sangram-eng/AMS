package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.PassengerRegistration;

public interface PassengerRegistrationRepository extends JpaRepository<PassengerRegistration, Long> {

}
