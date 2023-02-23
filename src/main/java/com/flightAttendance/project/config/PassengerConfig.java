package com.flightAttendance.project.config;
import com.flightAttendance.project.entitites.Passenger;
import com.flightAttendance.project.repositories.PassengerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PassengerConfig {

    @Bean
    CommandLineRunner commandLineRunner(PassengerRepository passengerRepository){
        return args -> {
            Passenger p1 = new Passenger("Toronto","Ankara","Ahmet","ahmet@gmail.com", LocalDate.of(2003, Month.JANUARY,5));
            Passenger p2 = new Passenger("Warsaw","Istanbul","Cengiz","mcayhan@gmail.com",LocalDate.of(2001,Month.AUGUST,15));
            Passenger p3 = new Passenger("Dubai","Antalya","Mehmet","mehmet@gmail.com",LocalDate.of(1998,Month.APRIL,11));
            passengerRepository.saveAll(List.of(p1,p2,p3));
        };
    }

}
