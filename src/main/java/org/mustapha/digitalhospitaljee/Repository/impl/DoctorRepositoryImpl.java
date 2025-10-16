package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.Exceptions.DoctorException;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DoctorService;

import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    private final EntityManagerFactory emf;

    public DoctorRepositoryImpl() {
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void createDoctor(Doctor doctor) throws DoctorException {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(doctor);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DoctorException("failed to create doctor" + e);
        }
    }

    @Override
    public void delete(Long id) throws DoctorException {
        EntityManager em = emf.createEntityManager();

        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                em.remove(doctor);
                tx.commit();
            }
        } catch (RuntimeException e) {
           throw new DoctorException("failed to delete doctor"+e);
        }
    }

    @Override
    public void update(Doctor doctor) throws DoctorException{
        EntityManager em = emf.createEntityManager();

        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(doctor);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DoctorException("failed update the doctor "+e);
        }
    }

    @Override
    public List<Doctor> findAll() throws DoctorException{
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
        } catch (RuntimeException e) {
            throw new DoctorException("failed to get doctors list" +e);
        }
    }

    @Override
    public Doctor findById(Long id) throws DoctorException{
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Doctor.class, id);
        } catch (RuntimeException e) {
            throw new DoctorException("Failed to find doctor"+e);
        }
    }


    @Override
    public Doctor findByEmail(String email) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Doctor.class, email);
        } catch (RuntimeException e) {
            throw new DoctorException("Failed to find doctor"+e);
        }
    }

    public void closeFactory() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}

