package com.ams.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="refund")

public class Refund 
 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
    @JoinColumn(referencedColumnName = "id")
	private Bill billId;
	@OneToOne
    @JoinColumn(referencedColumnName = "id")
	private PassengerRegistration passengerId;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private FlightDetails flightId;
	@Column
	private String reason;
}


