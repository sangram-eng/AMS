package com.ams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="PassengerRegistration")

public class PassengerRegistration 
 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String userName;
	@Column
	private int age;
	@Column
	private Long dob;
	@Column
	private Long phoneNo;
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
	
	}
