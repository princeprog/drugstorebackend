package com.pach.drugstore.service;

import com.pach.drugstore.entity.Consultation;
import com.pach.drugstore.repository.ConsultationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultationService {
    @Autowired
    private ConsultationRepo consultationRepo;

    public Consultation saveConsultation(Consultation consultation) {
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
}
