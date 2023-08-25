package com.ams.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="covidvaccine_details")
	
	
public class CovidVaccineDetails {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;
			@Column
			private String name;
			@Column
			private String dob;
			@Column
			private Date firstVaccineDate;
			@Column
			private Date thirdVaccineDate;
			@Column
			private String phoneNo;
			@Column
			private String certificateNo;
			
			
		  

}
