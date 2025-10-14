package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import javax.print.Doc;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Date and time is required")
    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "consultation_status", nullable = false, columnDefinition = "ENUM('CANCELED', 'COMPLETED', 'CONFIRMED', 'PENDING') DEFAULT 'PENDING'")
    ConsultationStatus consultationStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    private String report;

    public Consultation(){}

    public Consultation(Patient patient, ConsultationStatus consultationStatus, LocalDateTime dateTime, String report) {
        this.patient = patient;
        this.consultationStatus = consultationStatus;
        this.dateTime = dateTime;
        this.report = report;
    }


    /**
     * Getters and Setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ConsultationStatus getConsultationStatus() {
        return consultationStatus;
    }

    public void setConsultationStatus(ConsultationStatus consultationStatus) {
        this.consultationStatus = consultationStatus;
    }

    public Patient getPatient() {
        return patient;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setReport(String report){
        this.report = report;
    }
    public String getReport(){
        return this.report;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", consultationStatus=" + consultationStatus +
                ", patient=" + patient +
                ", report='" + report + '\'' +
                '}';
    }
}
