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

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "consultation_status", nullable = false)
    private ConsultationStatus consultationStatus;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private String report;

    public Consultation(){}

    public Consultation(Patient patient, Doctor doctor, Room room, ConsultationStatus consultationStatus, LocalDateTime startTime, String report) {
        this.patient = patient;
        this.doctor = doctor;
        this.room = room;
        this.consultationStatus = consultationStatus;
        this.startTime = startTime;
        this.report = report;
    }

    public LocalDateTime getEndTime() { return startTime.plusMinutes(30); }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public ConsultationStatus getConsultationStatus() { return consultationStatus; }
    public void setConsultationStatus(ConsultationStatus consultationStatus) { this.consultationStatus = consultationStatus; }
    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
    public Doctor getDoctor() { return doctor; }
    public void setDoctor(Doctor doctor) { this.doctor = doctor; }
    public Room getRoom() { return room; }
    public void setRoom(Room room) { this.room = room; }
    public String getReport() { return report; }
    public void setReport(String report) { this.report = report; }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + getEndTime() +
                ", consultationStatus=" + consultationStatus +
                ", patient=" + patient.getFirstName() +
                ", doctor=" + doctor.getFirstName() +
                ", room=" + (room != null ? room.getName() : "N/A") +
                ", report='" + report + '\'' +
                '}';
    }
}
