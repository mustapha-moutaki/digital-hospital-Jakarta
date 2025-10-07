package org.mustapha.digitalhospitaljee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.mustapha.digitalhospitaljee.model.Patient;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospitalPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Patient patient = new Patient("Test User", 30);
        em.persist(patient);

        em.getTransaction().commit();
        em.close();
        emf.close();

        System.out.println("Patient saved, ID: " + patient.getId());
    }
}
