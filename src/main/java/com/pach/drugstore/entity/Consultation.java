package com.pach.drugstore.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long consultationId;

    private Date consultationDate;
    private Time consultationTime;

    private String googleMeetLink;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Consultation() {
    }

    public Consultation(Date consultationDate, Time consultationTime, String googleMeetLink) {
        this.consultationDate = consultationDate;
        this.consultationTime = consultationTime;
        this.googleMeetLink = googleMeetLink;
    }

    public Long getConsultationId() {
        return consultationId;
    }

    public void setConsultationId(Long consultationId) {
        this.consultationId = consultationId;
    }

    public Date getConsultationDate() {
        return consultationDate;
    }

    public void setConsultationDate(Date consultationDate) {
        this.consultationDate = consultationDate;
    }

    public Time getConsultationTime() {
        return consultationTime;
    }

    public void setConsultationTime(Time consultationTime) {
        this.consultationTime = consultationTime;
    }

    public String getGoogleMeetLink() {
        return googleMeetLink;
    }

    public void setGoogleMeetLink(String googleMeetLink) {
        this.googleMeetLink = googleMeetLink;
    }
}
