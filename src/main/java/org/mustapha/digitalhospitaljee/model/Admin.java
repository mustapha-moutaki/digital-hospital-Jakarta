package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@Table(name = "admins")
public class Admin extends Person{

    public Admin() {
    }

    public Admin(String firstName, String lastname, String email, String password) {
        super(firstName, lastname, email, password);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
