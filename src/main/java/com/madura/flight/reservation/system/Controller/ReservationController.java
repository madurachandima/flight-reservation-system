package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.FlightRepository;
import com.madura.flight.reservation.system.dto.ReservationRequest;
import com.madura.flight.reservation.system.entities.Flight;
import com.madura.flight.reservation.system.entities.Reservation;
import com.madura.flight.reservation.system.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    @Autowired
     FlightRepository flightRepository;

    @Autowired
     ReservationService reservationService;

    @RequestMapping(value = "/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request,ModelMap modelMap){
      Reservation reservation = reservationService.bookFlight(request);
      modelMap.addAttribute("msg","Reservation created successfully and the id is : "+reservation.getId());

        return"reservationConformation";
    }
}

