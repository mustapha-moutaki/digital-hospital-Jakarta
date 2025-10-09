package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DoctorService;

import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    private EntityManagerFactory emf;

    public DoctorRepositoryImpl() {
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void createDoctor(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Failed adding doctor: doctor is null");
            return;
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(doctor);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            System.out.println("Error creating doctor");
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        if (id == null || id <= 0) {
            System.out.println("Failed to remove doctor: invalid id");
            return;
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Doctor doctor = em.find(Doctor.class, id);
            if (doctor != null) {
                em.remove(doctor);
                tx.commit();
                System.out.println("Doctor " + doctor.getName() + " removed successfully");
            } else {
                System.out.println("Doctor not found with id " + id);
                tx.rollback();
            }
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void update(Doctor doctor) {
        if (doctor == null) {
            System.out.println("Failed to update doctor info: doctor is null");
            return;
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.merge(doctor);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Doctor> findAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Doctor findById(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Doctor.class, id);
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

