package com.ams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="passenger")

public class PassengerRegistration 
 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String userName;
	@Column
	private String age;
	@Column
	private String dob;
	@Column
	private String phoneNo;
	@Column
	private String nationality;
	@Column
	private String emailId;
	@Column
	private String gender;
	@Column
	private String passportNo;
	@Column
	private String address;
    @ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private CovidVaccineDetails vaccineId;
	
	
	}
