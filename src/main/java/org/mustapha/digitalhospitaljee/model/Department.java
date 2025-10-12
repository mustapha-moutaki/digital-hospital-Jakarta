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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctorsList() {
        return doctorsList;
    }

    public void setDoctorsList(List<Doctor> doctorsList) {
        this.doctorsList = doctorsList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", doctorsList=" + doctorsList +
                ", roomList=" + roomList +
                '}';
    }
}
