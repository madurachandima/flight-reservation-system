package com.madura.flight.reservation.system.Repository;

import com.madura.flight.reservation.system.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
