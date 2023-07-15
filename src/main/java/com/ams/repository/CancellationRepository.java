package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.Cancellation;

public interface CancellationRepository extends JpaRepository<Cancellation, Long> {

}
