package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "doctors") // table that we want to be created in the database
public class Doctor extends Person{

    private String specialist;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;
    private List<Planning> planningList;

    public Doctor() {}

    public Doctor(String firstName, String lastname, String email, String password, String specialist, String department, List<Planning> planningList) {
            super(firstName, lastname, email, password);
        this.specialist = specialist;
        this.department = department;
        this.planningList = planningList;
    }



    @Override
    public String getRole() {
        return "Doctor";
    }
}
