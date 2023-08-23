package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.CovidVaccineDetails;

public interface CovidVaccineDetailsRepository extends JpaRepository<CovidVaccineDetails, Long> {
	 

}

