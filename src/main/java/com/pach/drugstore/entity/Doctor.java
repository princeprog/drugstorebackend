package com.pach.drugstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private int doctorId;

    private String name;
    private String email;
    private String specialization;

    public Doctor(){

    }

    public Doctor(String name, String email, String specialization){
        this.name = name;
        this.email = email;
        this.specialization = specialization;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void getDoctorId(int userId) {
        this.doctorId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
