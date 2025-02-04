package com.pach.drugstore.controller;

import com.pach.drugstore.entity.Consultation;
import com.pach.drugstore.service.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> deleteConsultation(@PathVariable Long id) {
        if (id == null) {
            return ResponseEntity.badRequest().body("Invalid booking ID");
        }

        try {
            consultationService.deleteConsultation(id);
            return ResponseEntity.ok("Booking deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting booking");
        }
    }


    // New endpoint to fetch booked times by consultation date
    @GetMapping("/getBookedTimes/{date}")
    public List<String> getBookedTimes(@PathVariable String date) {
        return consultationService.getBookedTimesByDate(date);
    }
}
