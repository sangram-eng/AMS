package com.ams.bean;

import com.ams.entity.Bill;
import com.ams.entity.BookTicket;

import lombok.Data;

@Data

public class Billinfo {
	  private String id;
	  private String userName;
	  private String ticketId;
	  
	public Bill convertToEntity() 
	 {
		
		Bill  bill= new  Bill();
			if(id!=null  && id!="0")			
			bill.setId(Long.valueOf(id));
			bill.setUserName( userName);
			
			  if(ticketId!=null && ticketId!="") { BookTicket bookTicket= new BookTicket();
			  bookTicket.setId(Long.valueOf(ticketId)); bill.setTicketId(bookTicket); }		
	 
				return bill;
  }
}
