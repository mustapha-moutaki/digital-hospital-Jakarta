package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultations")
public class Consultation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "consultation_status", nullable = false)
    private ConsultationStatus consultationStatus;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;


    @Column(name = "startTime", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "report")
    private String report;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    // Getters and Setters

    public Long getId() { return id; }

    public ConsultationStatus getConsultationStatus() { return consultationStatus; }
    public void setConsultationStatus(ConsultationStatus consultationStatus) { this.consultationStatus = consultationStatus; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public String getReport() { return report; }
    public void setReport(String report) { this.report = report; }

    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
}
