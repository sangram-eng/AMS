package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.BookTicket;

public interface BookTicketRepository extends JpaRepository<BookTicket, Long> {
 

}
