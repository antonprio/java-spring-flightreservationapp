package com.antonprio.flightreservation.controllers;

import com.antonprio.flightreservation.dto.ReservationRequest;
import com.antonprio.flightreservation.entities.Flight;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.FlightRepository;
import com.antonprio.flightreservation.services.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ReservationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        LOGGER.info("inside showCompleteReservation(flightId : " + flightId + ")");
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        Flight flight = optionalFlight.get();
        LOGGER.info("Flight is : " + flight);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    @Transactional
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        LOGGER.info("inside completeReservation(request : " + request + ")");
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully with id : " + reservation.getId());
        return "reservationConfirmation";
    }
}
