package com.example.airline_api.services;

import com.example.airline_api.models.BookingDTO;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;

//    @Transactional
//    private Flight cancelFlight(Flight flight){
//        flightRepository.remove(flight);
//        return flight;
//    }

    public Flight findFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    public Flight addPassengerToFlight(BookingDTO bookingDTO, Long id) {
        Flight flight = flightRepository.findById(id).get();
        Passenger passenger = passengerRepository.findById(bookingDTO.getPassengerId()).get();
        flight.addPassenger(passenger);
        //passengerRepository.save(passenger);
        flightRepository.save(flight);
        return flight;
    }

    //Create/Post
//    public void cancelFlight(Long id){
//        Flight flight = flightRepository.findById(id).get();
//        for (Passenger passenger : flight.getPassengers()){
//            passenger.removeFlight(flight);
//        }
//        flightRepository.deleteById(id);
//    }

    public void deleteFlight(Long id){
        flightRepository.deleteById(id);
    }

}
