package com.example.airline_api.components;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import com.example.airline_api.services.PassengerService;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    PassengerService passengerService;



    public DataLoader(){

    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
//boujieFlight & superPassenger & slowPassenger
        Flight boujieFlight = new Flight("Paris", 200, "01/01/2023", "12:12");
        flightRepository.save(boujieFlight);

        Passenger superPassenger = new Passenger("Anna", "anna@gmail.com");
        superPassenger.addFlight(boujieFlight);
        passengerRepository.save(superPassenger);

        Passenger slowPassenger = new Passenger("Lolita", "lolita@gmail.com");
        slowPassenger.addFlight(boujieFlight);
        passengerRepository.save(slowPassenger);

//fancyFlight & fancyPassenger & funnyPassenger
        Flight fancyFlight = new Flight("London", 202, "02/02/2023", "11:11");
        flightRepository.save(fancyFlight);

        Passenger fancyPassenger = new Passenger("Unaise", "unaise@gmail.com");
        fancyPassenger.addFlight(fancyFlight);
        passengerRepository.save(fancyPassenger);

        Passenger funnyPassenger = new Passenger("Lola", "lola@gmail.com");
        funnyPassenger.addFlight(fancyFlight);
        passengerRepository.save(funnyPassenger);

//fastFlight & fastPassenger & furiousPassenger
        Flight fastFlight  = new Flight("Monaco", 100, "03/03/2023", "00:00");
        flightRepository.save(fastFlight);

        Passenger fastPassenger = new Passenger("Jj", "jj@gmail.com");
        fastPassenger.addFlight(fastFlight);
        passengerRepository.save(fastPassenger);

        Passenger furiousPassenger = new Passenger("Gisele", "gisele@gmail,com");
        furiousPassenger.addFlight(fastFlight);
        passengerRepository.save(furiousPassenger);

    }



}
