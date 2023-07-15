package com.ams.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ams.entity.Bill;
import com.ams.entity.BookTicket;
import com.ams.entity.Cancellation;
import com.ams.entity.FlightDetails;
import com.ams.entity.PassengerRegistration;

import lombok.Data;

@Data

public class Cancellationinfo 
  {
	private String id;
	private String passengerId;
	private String ticketId;
	private String flightId;
	private String billId;
	private String journeydate;
	private String journeytime;
	private String reason;
	
	public Cancellation convertToEntity()
	{
	   Cancellation cancellation= new Cancellation();
	       if(id!=null && id!="0")
	    	   cancellation.setId(Long.valueOf(id));
	           cancellation.setJourneytime(journeytime);
	           cancellation.setReason(reason);
	           
	           if (passengerId!=null && passengerId!="") {PassengerRegistration passenger= new PassengerRegistration();
	           passenger.setId(Long.valueOf(passengerId)); cancellation.setPassengerId(passenger); }
	           
	           if (ticketId!=null && ticketId!="") {BookTicket book= new BookTicket();
	           book.setId(Long.valueOf(flightId)); cancellation.setTicketId(book); }
	           
	           
	           if (flightId!=null && flightId!="") {FlightDetails flight= new FlightDetails();
	           flight.setId(Long.valueOf(flightId)); cancellation.setFlightId(flight); }
	           
	           if (billId!=null && billId!="") {Bill bill= new Bill();
	           bill.setId(Long.valueOf(flightId)); cancellation.setBillId(bill); }
	           
	           
	           SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
	       	try {
	       		if(journeydate!=null && !journeydate.equals(""))
	       		   cancellation.setJourneydate(format.parse(journeydate));
	       		
	       	}
	       	
	       	catch (ParseException e) {
	       		// TODO Auto-generated catch block
	         	e.printStackTrace();   
	           
	    	   
		
	}
			return cancellation;

	}
  }	
