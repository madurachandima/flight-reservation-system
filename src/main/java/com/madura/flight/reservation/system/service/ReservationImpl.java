package com.madura.flight.reservation.system.service;

import com.madura.flight.reservation.system.Repository.FlightRepository;
import com.madura.flight.reservation.system.Repository.PassengerRepository;
import com.madura.flight.reservation.system.Repository.ReservationRepository;
import com.madura.flight.reservation.system.dto.ReservationRequest;
import com.madura.flight.reservation.system.entities.Flight;
import com.madura.flight.reservation.system.entities.Passenger;
import com.madura.flight.reservation.system.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationImpl implements ReservationService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;


    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        Long flightId = request.getFlightId();
        Flight flight = flightRepository.getOne(flightId);

        Passenger passenger = new Passenger();
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setEmail(request.getPassengerEmail());
        passenger.setPhone(request.getPassengerPhoneNumber());
        Passenger savedPassenger = passengerRepository.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }
}
