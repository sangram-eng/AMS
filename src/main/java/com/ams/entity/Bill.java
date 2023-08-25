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
@Table(name="bill")
	public class Bill 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		  private Long id;
		  
		  @Column
		  private String userName;
		  @ManyToOne
		  @JoinColumn(referencedColumnName = "id")
		  private BookTicket ticketId;
		  @Column
		  private String price;

}
