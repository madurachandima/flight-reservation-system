package com.madura.flight.reservation.system.Controller;

import com.madura.flight.reservation.system.Repository.FlightRepository;
import com.madura.flight.reservation.system.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

@Controller
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @RequestMapping(value = "findFlights", method = RequestMethod.POST)
    public String findFlight(@RequestParam("from") String from, @RequestParam("to") String to,
                             @RequestParam("departureDate") String departureDate, ModelMap modelMap) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));

        try {
            Date date = dateFormat.parse(departureDate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            List<Flight> flightList = flightRepository.findFlights(from, to, sqlDate);
    modelMap.addAttribute("flights", flightList);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "displayFlight";
    }
}
