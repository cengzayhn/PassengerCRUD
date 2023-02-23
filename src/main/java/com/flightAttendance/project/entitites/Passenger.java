package com.flightAttendance.project.entitites;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@NoArgsConstructor
@ToString
@Table(name = "passenger")
public class Passenger {
    @Id
    @SequenceGenerator(name="passenger_sequence",sequenceName = "pasenger_sequence",allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE,generator = "passenger_sequence")
    @Column(updatable = false)
    private Long id;
    private String passengerTo; //destination of the passenger
    private String passengerFrom; // passenger's departure
    @Column(updatable = false)
    private String passengerName;
    @Column(updatable = false)
    private String passengerMail;
    @Column(updatable = false)
    private LocalDate passengerDob; //passenger's date of birth
    @Transient
    @Column(updatable = false)
    private Integer passengerAge;
    public Passenger(String passengerTo, String passengerFrom, String passengerName, String passengerMail, LocalDate passengerDob) {
        this.passengerTo = passengerTo;
        this.passengerFrom = passengerFrom;
        this.passengerName = passengerName;
        this.passengerMail = passengerMail;
        this.passengerDob = passengerDob;
    }
    public Long getId() {
        return id;
    }
    public String getPassengerTo() {
        return passengerTo;
    }
    public String getPassengerFrom() {
        return passengerFrom;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public String getPassengerMail() {
        return passengerMail;
    }
    public LocalDate getPassengerDob() {
        return passengerDob;
    }
    public Integer getPassengerAge() {
        return Period.between(passengerDob,LocalDate.now()).getYears();
    }
    public void setPassengerTo(String passengerTo) {
        this.passengerTo = passengerTo;
    }
    public void setPassengerFrom(String passengerFrom) {
        this.passengerFrom = passengerFrom;
    }
}
