package com.ams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ams.bean.Refundinfo;
import com.ams.entity.Refund;
import com.ams.service.RefundService;

@RestController
@RequestMapping("/refund")
public class RefundController {
	
	@Autowired
     RefundService refundService;
	

	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Refund register(@RequestBody Refundinfo refundinfo) {
	  return refundService.register(refundinfo);		
	}
	
	@RequestMapping(value="/update" , method=RequestMethod.PUT) 
	Refund update(@RequestBody Refundinfo refundinfo) {
		
		return refundService.update(refundinfo.convertToEntity());		
	}
	
	@GetMapping("/getAll")
	
	
	public List<Refund> getAll(){
		
		return refundService.getAll();
	}
	
@GetMapping("/getbyid")
	
	public Optional<Refund> getById(@RequestParam("id") Long id){
		
		return refundService.getById(id);
	}
}

