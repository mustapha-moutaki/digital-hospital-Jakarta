package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.hibernate.Transaction;
import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Patient;

import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {
    private EntityManagerFactory emf;
    public PatientRepositoryImpl(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @PersistenceContext
    EntityManager em;

    EntityTransaction tx = em.getTransaction();

    @Override
    public void createPatient(Patient patient) {
        if(patient != null){
            try{
                tx.begin();
                em.persist(patient);
                tx.commit();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("failed to create new patient ");
    }

    @Override
    public void delete(Long id) {
        if(id > 0){
            try{
                tx.begin();
                Patient patient =  em.find(Patient.class, id);
                em.remove(patient);
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }else{
            System.out.println("failed to delete patient ");
        }
    }

    @Override
    public void update(Patient patient) {
        if(patient != null){
            try{
                tx.begin();
                em.merge(patient);
                tx.commit();
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("failed to update patient");
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> listPatient = em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
        em.close();
        return listPatient;
    }

    @Override
    public Patient findById(Long id) {
        return null;
    }
}
