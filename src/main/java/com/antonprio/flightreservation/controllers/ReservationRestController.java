package com.antonprio.flightreservation.controllers;

import com.antonprio.flightreservation.dto.ReservationUpdateRequest;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.isPresent() ? optionalReservation.get() : null;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        return reservationRepository.save(reservation);
    }
}
