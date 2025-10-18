package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.Exceptions.DoctorException;
import org.mustapha.digitalhospitaljee.Exceptions.PatientException;
import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.model.Person;

import java.util.List;

public class PatientRepositoryImpl implements PatientRepository {

    private final EntityManagerFactory emf;

    public PatientRepositoryImpl(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void createPatient(Patient patient) throws PatientException {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(patient);
            tx.commit();
        } catch (RuntimeException e) {
            throw new PatientException("failed to create doctor" + e);
        }
    }

    @Override
    public void delete(Long id) throws PatientException {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Patient patient  = em.find(Patient.class, id);
            em.remove(patient);
            tx.commit();
        } catch (RuntimeException e) {
            throw new PatientException("failed to delete patient" + e);
        }
    }

    @Override
    public void update(Patient patient) throws PatientException {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(patient);
            tx.commit();
        } catch (RuntimeException e) {
            throw new PatientException("failed to update patient" + e);
        }
    }

    @Override
    public List<Patient> findAll() throws PatientException {
        EntityManager em = emf.createEntityManager();
        try (em) {
             return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList();
        } catch (RuntimeException e) {
            throw new PatientException("failed to get Patient list" + e);
        }
    }

    @Override
    public Patient findById(Long id) throws PatientException {
        EntityManager em = emf.createEntityManager();
        try(em){
            return em.find(Patient.class, id);
        }
    }

    @Override
    public List<Patient> getAllByDoctorId(Long id) throws PatientException {
        EntityManager em = emf.createEntityManager();
        try(em){
            return   em.createQuery("SELECT d.patient FROM Department d WHERE d.doctor.id = :doctorId", Patient.class)
                    .setParameter("doctorId", id)
                    .getResultList();
        } catch (RuntimeException e) {
            throw  new PatientException("failed to get doctor patients list");
        }
    }

//    @Override
//    public Patient findByEmail(String email) {
//        EntityManager em = emf.createEntityManager();
//        try {
//
//            TypedQuery<Person> query = em.createQuery(
//                    "SELECT p FROM Person p WHERE p.email = :email", Person.class
//            );
//            query.setParameter("email", email);
//            Person person = query.getSingleResult();
//
//
//            if(person instanceof Patient) {
//                return (Patient) person;
//            } else {
//                return null;
//            }
//
//        } catch (NoResultException e) {
//            return null;
//        } catch (RuntimeException e) {
//            throw new PatientException("Failed to find patient: " + e);
//        } finally {
//            em.close();
//        }
//    }

    @Override
    public Patient findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Patient> query = em.createQuery(
                    "SELECT p FROM Patient p WHERE p.email = :email", Patient.class
            );
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (RuntimeException e) {
            throw new DoctorException("Failed to find patient: " + e);
        } finally {
            em.close();
        }
    }

//    public Patient findByEmail(String email) {
//    EntityManager em = emf.createEntityManager();
//    try(em){ return em.find(Patient.class, email);
//    } }

    void closeFactory(){
        if(emf.isOpen()){
            emf.close();
        }
    }
}
