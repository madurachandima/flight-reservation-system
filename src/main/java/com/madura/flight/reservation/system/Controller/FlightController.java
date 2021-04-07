package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.FlightRepository;
import com.madura.flight.reservation.system.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value = "findFlights", method = RequestMethod.POST)
    public String findFlight(@RequestParam("from") String from, @RequestParam("to") String to,
                             @RequestParam("departureDate") String departureDate, ModelMap modelMap) {
        List<Flight> flightList = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flightList);

        return "displayFlight";
    }
}
