package com.ams.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	  @OneToOne
	  @JoinColumn(referencedColumnName = "id")
	  private PassengerRegistration passengerId;
	  @OneToOne
	  @JoinColumn(referencedColumnName = "id")
	  private BookTicket ticketId;
	  @ManyToOne
	  @JoinColumn(referencedColumnName = "id")
	  private FlightDetails flightId;
	  @OneToOne
	  @JoinColumn(referencedColumnName = "id")
	  private Bill billId;
	  @Column
	  private Date journeydate;
	  @Column
	  private String journeytime;
	  @Column
	  private String reason;
}

