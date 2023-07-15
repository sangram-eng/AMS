package com.ams.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ams.entity.Bill;
import com.ams.entity.BookTicket;

import lombok.Data;

@Data

public class Billinfo {
	  private String id;
	  private String userName;
	  private String ticketId;
	  private String price;
	  private String journeydate;
	  private String journeyTime;

	public Bill convertToEntity() 
	 {
		
		Bill  bill= new  Bill();
			if(id!=null  && id!="0")			
			bill.setId(Long.valueOf(id));
			bill.setUserName( userName);
			bill.setPrice(price);
			bill.setJourneyTime(journeyTime);
			
			
			  if(ticketId!=null && ticketId!="") { BookTicket bookTicket= new BookTicket();
			  bookTicket.setId(Long.valueOf(ticketId)); bill.setTicketId(bookTicket); }
			 
			  SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
		       	try {
		       		if(journeydate!=null && !journeydate.equals(""))
		       		   bill.setJourneyDate(format.parse(journeydate));
		       		
		       	}
		       	
		       	catch (ParseException e) {
		       		// TODO Auto-generated catch block
		         	e.printStackTrace();   
			
			
	 }
				return bill;
  }
}
