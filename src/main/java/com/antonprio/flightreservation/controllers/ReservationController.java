package com.antonprio.flightreservation.controllers;

import com.antonprio.flightreservation.dto.ReservationRequest;
import com.antonprio.flightreservation.entities.Flight;
import com.antonprio.flightreservation.entities.Reservation;
import com.antonprio.flightreservation.repos.FlightRepository;
import com.antonprio.flightreservation.services.ReservationService;
import com.antonprio.flightreservation.services.ReservationServiceImpl;
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

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        Flight flight = optionalFlight.get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    @Transactional
    public String completeReservation(ReservationRequest request, ModelMap modelMap) {
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation created successfully with id : " + reservation.getId());
        return "reservationConfirmation";
    }
}
