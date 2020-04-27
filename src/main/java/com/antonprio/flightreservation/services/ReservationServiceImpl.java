package com.antonprio.flightreservation.services;

import com.antonprio.flightreservation.dto.ReservationRequest;
import com.antonprio.flightreservation.entities.Flight;
import com.antonprio.flightreservation.entities.Passanger;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.FlightRepository;
import com.antonprio.flightreservation.repos.PassangerRepository;
import com.antonprio.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassangerRepository passangerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        //Make payment line

        Long flightID = request.getFlightId();
        Optional<Flight> optionalFlight = flightRepository.findById(flightID);
        Flight flight = optionalFlight.get();

        Passanger passanger = new Passanger();
        passanger.setFirstName(request.getPassangerFirstName());
        passanger.setMiddleName(request.getPassangerMiddleName());
        passanger.setLastName(request.getPassangerLastName());
        passanger.setPhone(request.getPassangerPhone());
        passanger.setEmail(request.getPassangerEmail());
        Passanger savedPassanger = passangerRepository.save(passanger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassanger(savedPassanger);
        reservation.setCheckedIn(false);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
}
