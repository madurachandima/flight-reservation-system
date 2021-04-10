package com.madura.flight.reservation.system.service;

import com.madura.flight.reservation.system.dto.ReservationRequest;
import com.madura.flight.reservation.system.entities.Reservation;

public interface ReservationService {
  Reservation bookFlight(ReservationRequest reservation);
}
