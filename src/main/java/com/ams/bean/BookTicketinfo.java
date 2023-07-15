package com.ams.bean;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.ams.entity.BookTicket;
import com.ams.entity.FlightDetails;
import com.ams.entity.PassengerRegistration;

import lombok.Data;

@Data

public class BookTicketinfo 
 {
	private String id;
	private String passengerId;
	private String price;
	private String flightId;
	private String journeydate;
	private String journeytime;
	
  public BookTicket convertToEntity()
  {
	BookTicket book= new BookTicket();
	  if(id!=null && id!="0")
      book.setId(Long.valueOf(id));		
      book.setPrice(price);
      book.setJourneytime(journeytime);
      
      
      if (passengerId!=null && passengerId!="") {PassengerRegistration passenger= new PassengerRegistration();
      passenger.setId(Long.valueOf(passengerId)); book.setPassengerId(passenger); }
      
      if (flightId!=null && flightId!="") {FlightDetails flight= new FlightDetails();
      flight.setId(Long.valueOf(flightId)); book.setFlightId(flight); }
      
      
      SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
  	try {
  		if(journeydate!=null && !journeydate.equals(""))
  			book.setJourneydate(format.parse(journeydate));
  		
  	}
  	
  	catch (ParseException e) {
  		// TODO Auto-generated catch block
    	e.printStackTrace();
  	}
	return book;
  	
  }
   
 }


