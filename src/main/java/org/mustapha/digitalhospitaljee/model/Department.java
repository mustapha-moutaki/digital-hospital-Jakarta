package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name  = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "the name is required")
    @Column(length = 50, nullable = false)
    protected String name;

    @OneToMany(mappedBy = "department")
    protected List<Doctor> doctorsList = new ArrayList<>();

    @OneToMany(mappedBy = "department")
    protected List<Room>roomList;

    public Department(){}
   public Department(Long id, String name, List<Doctor> doctorsList) {
        this.id = id;
        this.name = name;
        this.doctorsList = doctorsList;
    }
}
