package com.madura.flight.reservation.system.Repository;

import com.madura.flight.reservation.system.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    @Query("FROM Flight WHERE departureCity=:departureCity AND arrivalCity=:arrivalCity AND dateOfDeparture=:dateOfDeparture")
    List<Flight> findFlights(@Param("departureCity") String from, @Param("arrivalCity") String to, @Param("dateOfDeparture") Date departureDate);
}

