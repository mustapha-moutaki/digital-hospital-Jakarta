package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name ="users")
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @NotBlank(message = "first name is required ")
    @Size(min = 3, max = 50, message = "first name must be between 3 and 50 character")
    protected String firstName;

    @NotBlank(message = "last name is required")
    @Size(min = 3, max = 20, message = "last name must be between 3 and 20 character")
    protected String lastname;

    @NotBlank(message = "email is required")
    @Email(message = "invalid email format")
    protected String email;

    @NotBlank(message="password is required")
    @Column(nullable = false)
    protected String password;

    @OneToMany(mappedBy = "person")
    List<Consultation> consultationList;

    public Person(){

    }
    public Person(String firstName, String lastname, String email, String password){
        this.firstName = firstName;
        this.lastname =  lastname;
        this.email = email;
        this.password =  password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return ("first name : "+ this.firstName + " last name: "+this.lastname+" email: "+this.email);
    }
}
