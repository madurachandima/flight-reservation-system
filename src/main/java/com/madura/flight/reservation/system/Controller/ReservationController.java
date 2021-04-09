package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.FlightRepository;
import com.madura.flight.reservation.system.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap) {

        Flight flight = flightRepository.findById(flightId).get();
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }
    @RequestMapping(value = "/completeReservation",method = RequestMethod.POST)
    public String completeReservation(){
        return"";
    }
}
