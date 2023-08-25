package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.CovidVaccineDetailsinfo;
import com.ams.entity.CovidVaccineDetails;
import com.ams.repository.CovidVaccineDetailsRepository;

@Service
public class CovidVaccineDetailsService {
@Autowired
	
    CovidVaccineDetailsRepository CovidVaccineDetailsRepository;
	
	public CovidVaccineDetails register(CovidVaccineDetailsinfo covidvaccinedetailsinfo) {
		return CovidVaccineDetailsRepository.save(covidvaccinedetailsinfo.convertToEntity());
	}
	
	public CovidVaccineDetails update(CovidVaccineDetails covidvaccinedetails) {
		return CovidVaccineDetailsRepository.save(covidvaccinedetails);
	}
	
	public List<CovidVaccineDetails> getAll() {
		return CovidVaccineDetailsRepository.findAll();
	}
	
	public Optional<CovidVaccineDetails> getById(Long id) {
		return CovidVaccineDetailsRepository.findById(id);
		
	}

}


