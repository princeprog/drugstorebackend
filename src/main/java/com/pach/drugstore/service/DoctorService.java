package com.pach.drugstore.service;

import com.pach.drugstore.entity.Doctor;
import com.pach.drugstore.entity.User;
import com.pach.drugstore.repository.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepo doctorRepo;

    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    public List<Doctor> findAllDoctors() {
        return doctorRepo.findAll();
    }

    public Doctor findDoctorById(int id) {
        return doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
    }

    public Doctor updateDoctor(Doctor updatedDoctor, int id) {
        Doctor existingDoctor = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existingDoctor.setName(updatedDoctor.getName());
        existingDoctor.setEmail(updatedDoctor.getEmail());
        existingDoctor.setSpecialization(updatedDoctor.getSpecialization());
        return doctorRepo.save(existingDoctor);
    }

    public void deleteDoctor(int id) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new RuntimeException("Doctor not found"));
        doctorRepo.delete(doctor);
    }
}
