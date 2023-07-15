package com.ams.bean;

import com.ams.entity.FlightDetails;

import lombok.Data;

@Data

public class FlightDetailsinfo {
	private String id;
	private String name;
	private String flightCode;
	private String flightZone;
	
	    public FlightDetails convertToEntity()
	    {
	    	FlightDetails flight = new FlightDetails();
	    	if(id!=null  && id!="0")
	    	flight.setId(Long.valueOf(id));
	    	flight.setName(name);
	    	flight.setFlightCode(flightCode);
	    	flight.setFlightZone(flightZone);
	    return flight;
	    }

}
