package com.ams.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.bean.BookTicketinfo;
import com.ams.bean.PassengerRegistrationinfo;
import com.ams.entity.BookTicket;
import com.ams.entity.PassengerRegistration;
import com.ams.repository.BookTicketRepository;
import com.ams.repository.PassengerRegistrationRepository;

@Service
public class BookTicketService {

@Autowired
	
    BookTicketRepository BookTicketRepository;
	
	public BookTicket register(BookTicketinfo bookticketinfo) {
		return BookTicketRepository.save(bookticketinfo.convertToEntity());
	}
	
	public BookTicket update(BookTicket bookticket) {
		return BookTicketRepository.save(bookticket);
	}
	
	public List<BookTicket> getAll() {
		return BookTicketRepository.findAll();
	}
	
	public Optional<BookTicket> getById(Long id) {
		return BookTicketRepository.findById(id);
		
	}

}
