package com.antonprio.flightreservation.controllers;

import com.antonprio.flightreservation.dto.ReservationUpdateRequest;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ReservationRestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationRestController.class);

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        LOGGER.info("Inside findReservation() with param id : " + id);
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        return optionalReservation.isPresent() ? optionalReservation.get() : null;
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
        LOGGER.info("Inside updateReservation() with param request : " + request);
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setNumberOfBags(request.getNumberOfBags());
        reservation.setCheckedIn(request.getCheckedIn());
        LOGGER.info("Saving reservation");
        return reservationRepository.save(reservation);
    }
}
