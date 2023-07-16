package com.ams.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="book_ticket")

	public class BookTicket 
	 {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long id;
		  @OneToOne
		  @JoinColumn(referencedColumnName = "id")
		  private PassengerRegistration passengerId;
		  @Column
		  private String price;
		  @OneToOne
		  @JoinColumn(referencedColumnName = "id")
		  private FlightDetails flightId;
		  @Column
		  private Date journeydate;
		  @Column
		  private String journeytime;

}
