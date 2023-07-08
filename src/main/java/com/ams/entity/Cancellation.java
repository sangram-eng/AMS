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
@Table(name="Cancellation")

public class Cancellation 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long ticketid;
	  @Column
	  private String source;
	  @Column
	  private String destination;
	  @Column
	  private Long price;
	  @Column
	  private String flightcode;
	  @Column
	  private String flightname;
	  @Column
	  private Long journeydate;
	  @Column
	  private Long journeytime;
	  @Column
	  private String username;
	  @Column
	  private String name;
	  @Column
	  private String reason;
}
