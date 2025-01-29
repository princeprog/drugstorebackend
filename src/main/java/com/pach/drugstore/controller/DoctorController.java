package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Doctor;
import com.pach.drugstore.entity.User;
import com.pach.drugstore.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/save")
    public Doctor saveDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("/getalldoctors")
    public List<Doctor> findAllDoctors() {
        return doctorService.findAllDoctors();
    }

    @GetMapping("/getdoctorbyid/{id}")
    public Doctor findDoctorById(@PathVariable int id) {
        return doctorService.findDoctorById(id);
    }

    @PutMapping("/updatedoctor/{id}")
    public Doctor updateDoctor(@RequestBody Doctor updatedDoctor, @PathVariable int id) {
        return doctorService.updateDoctor(updatedDoctor, id);
    }

    @DeleteMapping("/deletedoctor/{id}")
    public void deleteDoctor(@PathVariable int id) {
        doctorService.deleteDoctor(id);
    }
}
