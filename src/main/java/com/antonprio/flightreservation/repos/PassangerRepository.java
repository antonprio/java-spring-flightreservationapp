package com.antonprio.flightreservation.repos;

import com.antonprio.flightreservation.entities.Passanger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassangerRepository extends JpaRepository<Passanger, Long> {
}
