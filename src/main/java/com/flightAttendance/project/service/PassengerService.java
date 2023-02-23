package com.flightAttendance.project.service;
import com.flightAttendance.project.entitites.Passenger;
import com.flightAttendance.project.repositories.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRepository passengerRepository;
    public List<Passenger> getPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long passengerId){
        return passengerRepository.findById(passengerId).orElseThrow(()->new IllegalStateException("passenger does not exist"));
    }

    public void addNewPassenger(Passenger passenger){
        Optional<Passenger> optionalPassenger = passengerRepository.findPassengerByPassengerMail(passenger.getPassengerMail());
        if (optionalPassenger.isPresent()){
            throw new IllegalStateException("email has taken");
        }passengerRepository.save(passenger);
    }
    public void deletePassenger(Long id){
        boolean exists = passengerRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("passenger already does not exist");
        }passengerRepository.deleteById(id);
    }
    @Transactional
    public void updatePassenger(Long id,String newPassengerTo, String newPassengerFrom){
        Passenger passenger = passengerRepository.findById(id).orElseThrow(()->new IllegalStateException("passenger does not exist"));
        if (newPassengerTo!= null&& newPassengerTo.length()>0){
            passenger.setPassengerTo(newPassengerTo);
        }
        if (newPassengerFrom!= null&& newPassengerFrom.length()>0){
            passenger.setPassengerFrom(newPassengerFrom);
        }
    }
}
