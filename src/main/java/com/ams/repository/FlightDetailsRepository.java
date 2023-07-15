package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.FlightDetails;

public interface FlightDetailsRepository extends JpaRepository<FlightDetails, Long> {

}


