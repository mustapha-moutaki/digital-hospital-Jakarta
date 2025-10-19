package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(length = 30, unique = true, nullable = false)
    private String name;

    @Min(value = 1, message = "Capacity must be at least 1")
    @Max(value = 55, message = "Capacity cannot exceed 55")
    private int capacity;

    @OneToMany(mappedBy = "room")
    private List<Consultation> consultations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    public Room(){}

    public Room(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public boolean checkAvailability(LocalDateTime desiredStartTime){
        LocalDateTime desiredEndTime = desiredStartTime.plusMinutes(30);
        for(Consultation c : consultations){
            LocalDateTime existingStart = c.getDateTime();
            LocalDateTime existingEnd = c.getStartTime();
            if(desiredStartTime.isBefore(existingEnd) && desiredEndTime.isAfter(existingStart)){
                return false;
            }
        }
        return true; // available rooms
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public Department getDepartment() { return department; }
    public void setDepartment(Department department) { this.department = department; }
    public List<Consultation> getConsultations() { return consultations; }
}
