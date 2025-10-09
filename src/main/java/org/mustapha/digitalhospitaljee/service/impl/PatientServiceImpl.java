package org.mustapha.digitalhospitaljee.service.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.PatientService;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");
   
    public List<Patient> getAllPatients() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
        } finally {
            em.close();
        }
    }

    public void savePatient(Patient patient) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(patient);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
