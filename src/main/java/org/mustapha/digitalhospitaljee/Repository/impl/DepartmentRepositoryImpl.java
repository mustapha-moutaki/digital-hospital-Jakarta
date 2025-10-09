package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.mustapha.digitalhospitaljee.Repository.DepartmentRepository;
import org.mustapha.digitalhospitaljee.model.Department;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    EntityManagerFactory emf;
    public DepartmentRepositoryImpl(){
        emf.createEntityManager();
    }


    @Override
    public void create(Department department) {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.commit();
            em.persist(department);
            tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Department department) {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(department);
            tx.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Department depar = em.find(Department.class, id);
            em.remove(depar);
            tx.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department findDepartment(Long id) {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Department.class, id);
        }
    }

    @Override
    public List<Department> departmentList() {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        }
    }
}
