package com.flightAttendance.project.repositories;
import com.flightAttendance.project.entitites.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Long> {
    @Query("SELECT p from Passenger p WHERE p.passengerMail=?1")
    Optional<Passenger> findPassengerByPassengerMail(String mail);
}
