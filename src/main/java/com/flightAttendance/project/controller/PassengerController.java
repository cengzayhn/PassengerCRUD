package com.flightAttendance.project.controller;
import com.flightAttendance.project.entitites.Passenger;
import com.flightAttendance.project.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/passenger")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService passengerService;
    @GetMapping("/getall")
    public List<Passenger> getPassengers(){
        return passengerService.getPassengers();
    }
    @PostMapping
    public void registerNewPassenger(@RequestBody Passenger passenger){
        passengerService.addNewPassenger(passenger);
    }

    @DeleteMapping(path = "{passengerId}")
    public void deletePassenger(@PathVariable("passengerId") Long passengerId){
        passengerService.deletePassenger(passengerId);
    }
    @PutMapping(path = "{passengerId}")
    public void updatePassenger(@PathVariable("passengerId") Long passengerId){
        Passenger passenger = passengerService.getPassengerById(passengerId);
        passengerService.updatePassenger(passengerId,passenger.getPassengerTo(),passenger.getPassengerFrom());
    }
}







