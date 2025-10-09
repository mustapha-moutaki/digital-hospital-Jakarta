package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import java.time.LocalDate;
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

    @NotBlank(message = "consultation is required")
    @Column(nullable = false)
    ConsultationStatus consultationStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    Patient patient;

    public Consultation(){}

    public Consultation(Patient patient, ConsultationStatus consultationStatus, LocalDateTime dateTime) {
        this.patient = patient;
        this.consultationStatus = consultationStatus;
        this.dateTime = dateTime;
    }



}
