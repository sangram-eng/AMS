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
@Table(name="cancellation")

public class Cancellation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @Column
	  private PassengerRegistration passengerId;
	  @Column
	 private BookTicket ticketId;
	 @Column
	  private FlightDetails flightId;
	  @Column
	  private Bill billId;
	  @Column
	  private Date journeydate;
	  @Column
	  private String journeytime;
	  @Column
	  private String reason;
}

