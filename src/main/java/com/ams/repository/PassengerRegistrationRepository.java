package com.ams.repository;

import com.ams.entity.PassengerRegistration;
import com.ams.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PassengerRegistrationRepository extends JpaRepository<PassengerRegistration, Long> {
    List<PassengerRegistration> findByUser(User user);
}
