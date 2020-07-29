package com.antonprio.flightreservation.services;

import com.antonprio.flightreservation.controllers.UserController;
import com.antonprio.flightreservation.dto.ReservationRequest;
import com.antonprio.flightreservation.entities.Flight;
import com.antonprio.flightreservation.entities.Passanger;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.FlightRepository;
import com.antonprio.flightreservation.repos.PassangerRepository;
import com.antonprio.flightreservation.repos.ReservationRepository;
import com.antonprio.flightreservation.util.EmailUtil;
import com.antonprio.flightreservation.util.PDFGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

    @Value("${com.antonprio.flightreservation.itinerary.dirpath}")
    private String ITINERARY_DIR;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassangerRepository passangerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest request) {

        LOGGER.info("Inside bookFlight()");

        //Make payment line

        Long flightID = request.getFlightId();
        LOGGER.info("Fetching flight for flightID : " + flightID);
        Optional<Flight> optionalFlight = flightRepository.findById(flightID);
        Flight flight = optionalFlight.get();

        Passanger passanger = new Passanger();
        passanger.setFirstName(request.getPassangerFirstName());
        passanger.setMiddleName(request.getPassangerMiddleName());
        passanger.setLastName(request.getPassangerLastName());
        passanger.setPhone(request.getPassangerPhone());
        passanger.setEmail(request.getPassangerEmail());
        LOGGER.info("Saving passanger info : " + passanger);
        Passanger savedPassanger = passangerRepository.save(passanger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassanger(savedPassanger);
        reservation.setCheckedIn(false);
        LOGGER.info("Saving reservation info : " + reservation);
        Reservation savedReservation = reservationRepository.save(reservation);

        String filePath = ITINERARY_DIR + savedReservation.getId() + ".pdf";
        LOGGER.info("Generating the Itinerary");
        pdfGenerator.generateItinerary(savedReservation, filePath);
        emailUtil.sendItinerary(passanger.getEmail(), filePath);

        return savedReservation;
    }
}
