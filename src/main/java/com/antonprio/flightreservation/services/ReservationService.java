package com.antonprio.flightreservation.services;

import com.antonprio.flightreservation.dto.ReservationRequest;
import com.antonprio.flightreservation.entities.Reservation;

public interface ReservationService {

    public Reservation bookFlight(ReservationRequest request);
}
