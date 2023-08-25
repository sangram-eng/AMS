package com.ams.bean;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.ams.entity.CovidVaccineDetails;

import lombok.Data;



@Data

public class CovidVaccineDetailsinfo  {
	private String id;
	private String name;
	private String dob;
	private String firstVaccineDate;
	private String thirdVaccineDate;
	private String phoneNo;
	private String certificateNo;
	
	    public  CovidVaccineDetails convertToEntity()
	    {
	    	CovidVaccineDetails covid = new CovidVaccineDetails();
	    	if(id!=null  && id!="0")
	    	covid.setId(Long.valueOf(id));
	    	covid.setName(name);
	    	covid.setDob(dob);
	    	covid.setPhoneNo(phoneNo);
	    	covid.setCertificateNo(certificateNo);
	    	
	    	 SimpleDateFormat format= new SimpleDateFormat("dd/MM/yyyy");
	    	  	try {
	    	  		if(firstVaccineDate!=null && !firstVaccineDate.equals(""))
	    	  			covid.setFirstVaccineDate(format.parse(firstVaccineDate));
	    	  		
	    	  	}
	    	  	
	    	  	catch (ParseException e) {
	    	  		// TODO Auto-generated catch block
	    	    	e.printStackTrace();
	    	  	}
	    	  	 SimpleDateFormat format1= new SimpleDateFormat("dd/MM/yyyy");
		    	  	try {
		    	  		if(thirdVaccineDate!=null && !thirdVaccineDate.equals(""))
		    	  			covid.setThirdVaccineDate(format1.parse(thirdVaccineDate));
		    	  		
		    	  	}
		    	  	
		    	  	catch (ParseException e) {
		    	  		// TODO Auto-generated catch block
		    	    	e.printStackTrace();
		    	  	}
	    return covid;
	    }

}


