package org.mustapha.digitalhospitaljee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patients")
@PrimaryKeyJoinColumn(name = "person_id")
public class Patient extends Person{

    private double weight;
    private double tall;
    private List<Consultation>consultationList;

    public Patient(){}
    public Patient(double weight, double tall, List<Consultation>consultationList){
        super(firstName, lastname, email, password);
        this.weight = weight;
        this.tall = tall;
        this.consultationList = consultationList;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getTall() {
        return tall;
    }

    public void setTall(double tall) {
        this.tall = tall;
    }

    public List<Consultation> getConsultationList() {
        return consultationList;
    }

    public void setConsultationList(List<Consultation> consultationList) {
        this.consultationList = consultationList;
    }

    @Override
    public String getRole() {
        return "patient";
    }
}
