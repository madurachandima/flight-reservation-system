package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.ReservationRepository;
import com.madura.flight.reservation.system.dto.ReservationUpdateRequest;
import com.madura.flight.reservation.system.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationResetController {
    @Autowired
    private ReservationRepository reservationRepository;

    @RequestMapping("/reservation/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        return reservationRepository.findById(id).get();
    }

    @RequestMapping("/reservation")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest updateRequest) {
        Reservation reservation = reservationRepository.findById(updateRequest.getId()).get();

        System.out.println(updateRequest.toString());
        reservation.setNumberOfBags(updateRequest.getNumberOfBags());
        reservation.setCheckedIn(updateRequest.getCheckedIn());

        return reservationRepository.save(reservation);
    }

}
