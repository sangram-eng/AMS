package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {
 

}
