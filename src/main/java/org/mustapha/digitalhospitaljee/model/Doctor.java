package org.mustapha.digitalhospitaljee.model;
import java.util.List;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "doctors") // table that we want to be created in the database
public class Doctor extends Person{

    private String specialist;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @OneToMany(mappedBy = "doctor")
    private List<Consultation> consultationList;

    public Doctor() {}

    public Doctor(String firstName, String lastname, String email, String password, String specialist, Department department, List<Consultation> consultationList) {
            super(firstName, lastname, email, password);
        this.specialist = specialist;
        this.department = department;
        this.consultationList = consultationList;
    }



    @Override
    public String getRole() {
        return "Doctor";
    }
}
