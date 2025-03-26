package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ams.entity.Refund;

public interface RefundRepository extends JpaRepository<Refund, Long> {
 
}
