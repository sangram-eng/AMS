package com.ams.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="passenger")
public class PassengerRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String passengerName;
    private String age;
    private String dob;
    private String phoneNo;
    private String nationality;
    private String emailId;
    private String gender;
    private String passportNo;
    private String address;
    private String vaccineId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
