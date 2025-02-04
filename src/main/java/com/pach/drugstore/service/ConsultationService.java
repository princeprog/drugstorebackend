package com.pach.drugstore.service;

import com.pach.drugstore.entity.Consultation;
import com.pach.drugstore.entity.User;
import com.pach.drugstore.repository.ConsultationRepo;
import com.pach.drugstore.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepo consultationRepo;

    @Autowired
    private UserRepo userRepo;

    public Consultation saveConsultation(Consultation consultation) {
        if (consultation.getUser() == null || consultation.getUser().getUserId() == 0) {
            throw new RuntimeException("User ID is required for Consultation.");
        }
        // Fetch the user from the database
        User user = userRepo.findById(consultation.getUser().getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + consultation.getUser().getUserId()));
        // Set the user before saving
        consultation.setUser(user);
        return consultationRepo.save(consultation);
    }

    public Consultation getConsultationById(long id) {
        return consultationRepo.findById(id).orElse(null);
    }

    public void deleteConsultation(long id) {
        System.out.println("Deleting consultation with id: " + id);
        consultationRepo.deleteById(id);
    }

    public Consultation updateConsultation(Consultation consultation, long id) {
        Consultation existingConsultation = consultationRepo.findById(id).orElse(null);
        if (existingConsultation != null) {
            existingConsultation.setConsultationDate(consultation.getConsultationDate());
            existingConsultation.setConsultationTime(consultation.getConsultationTime());
            existingConsultation.setGoogleMeetLink(consultation.getGoogleMeetLink());
            return consultationRepo.save(existingConsultation);
        }
        return null;
    }

    public List<Consultation> getAllConsultations() {
        return consultationRepo.findAll();
    }

    public List<String> getBookedTimesByDate(String date) {
        // Convert the date from string to LocalDate
        LocalDate localDate = LocalDate.parse(date); // Assuming date is in 'YYYY-MM-DD' format
        List<Consultation> consultations = consultationRepo.findByConsultationDate(localDate);
        List<String> bookedTimes = new ArrayList<>();

        for (Consultation consultation : consultations) {
            bookedTimes.add(consultation.getConsultationTime().toString());
        }

        return bookedTimes;
    }
}
