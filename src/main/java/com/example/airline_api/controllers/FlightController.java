package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;


    // Display all available flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(){
        return new ResponseEntity<>(flightRepository.findAll(), HttpStatus.OK);
    }

    // Display a specific flight
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        Flight flight = flightService.findFlight(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Add details of a new flight
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    // Book passenger on a flight
//    @PatchMapping(value = "/{id}")
//    public ResponseEntity<Long> addPassengerToFlight(
//            @RequestBody Long passengerId,
//            @PathVariable Long id){
//        Flight flight = flightService.getFlightById(id).get();
//        Booking booking = flightService.addPassengerToFlight(passengerId, id);
//        return new ResponseEntity<>(boo, HttpStatus.OK)
//    }
//
//    // Cancel flight
//    @DeleteMapping(value = "/{id}")
//    public ResponseEntity cancelFlight(){
//        return null;
//    }
//
}
