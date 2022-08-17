package com.spring.Hospital.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.spring.Hospital.entity.Appointment;


@Repository("appointmentRepository")
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

    @Query(value = "select a from Appointment a where a.email= :email")
    List<Appointment> findByEmail(@Param("email") String email);

	
}