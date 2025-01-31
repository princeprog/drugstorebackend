package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Consultation;
import com.pach.drugstore.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {
    @Autowired
    private ConsultationService consultationService;

    @PostMapping("/save")
    public Consultation saveConsultation(@RequestBody Consultation consultation) {
        return consultationService.saveConsultation(consultation);
    }

    @GetMapping("/getallconsultations")
    public List<Consultation> getAllConsultations() {
        return consultationService.getAllConsultations();
    }

    @GetMapping("/getconsultationbyid/{id}")
    public Consultation getConsultationById(@PathVariable long id) {
        return consultationService.getConsultationById(id);
    }

    @PutMapping("/updateconsultation/{id}")
    public Consultation updateConsultation(@RequestBody Consultation consultation, @PathVariable long id) {
        return consultationService.updateConsultation(consultation, id);
    }

    @DeleteMapping("/deleteconsultation/{id}")
    public void deleteConsultation(@PathVariable long id) {
        consultationService.deleteConsultation(id);
    }

    // New endpoint to fetch booked times by consultation date
    @GetMapping("/getBookedTimes/{date}")
    public List<String> getBookedTimes(@PathVariable String date) {
        return consultationService.getBookedTimesByDate(date);
    }
}
