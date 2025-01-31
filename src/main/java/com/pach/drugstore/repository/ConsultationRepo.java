package com.pach.drugstore.repository;

import com.pach.drugstore.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ConsultationRepo extends JpaRepository<Consultation, Long> {

    // Custom query to find consultations by consultation date
    List<Consultation> findByConsultationDate(Date consultationDate);
}
