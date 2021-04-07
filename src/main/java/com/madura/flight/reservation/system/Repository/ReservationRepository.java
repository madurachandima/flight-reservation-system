package com.madura.flight.reservation.system.Repository;

import com.madura.flight.reservation.system.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
