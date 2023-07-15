package com.ams.bean;

import com.ams.entity.Bill;
import com.ams.entity.FlightDetails;
import com.ams.entity.PassengerRegistration;
import com.ams.entity.Refund;

import lombok.Data;

@Data

public class Refundinfo 
  {
	private String id;
	private String billId;
	private String passengerId;
	private String flightId;
	private String reason;
	
	public Refund convertToEntity()
	{
		Refund refund= new Refund();
		if(id!=null && id!="0")
	    	   refund.setId(Long.valueOf(id));
	           refund.setReason(reason);
	           
	           if (billId!=null && billId!="") {Bill bill= new Bill();
	           bill.setId(Long.valueOf(flightId)); refund.setBillId(bill); }
	           
	           
	           if (passengerId!=null && passengerId!="") {PassengerRegistration passenger= new PassengerRegistration();
	           passenger.setId(Long.valueOf(passengerId)); refund.setPassengerId(passenger); }
	           
	           if (flightId!=null && flightId!="") {FlightDetails flight= new FlightDetails();
	           flight.setId(Long.valueOf(flightId)); refund.setFlightId(flight); }
	           
	           
	           
			return refund;
	           
	}

}
