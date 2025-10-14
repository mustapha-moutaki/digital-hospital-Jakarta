package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mustapha.digitalhospitaljee.Exceptions.DepartmentException;
import org.mustapha.digitalhospitaljee.Repository.DepartmentRepository;
import org.mustapha.digitalhospitaljee.model.Department;

import java.util.List;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    private final EntityManagerFactory emf;
    public DepartmentRepositoryImpl(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }


    @Override
    public void create(Department department) throws DepartmentException {
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(department);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DepartmentException("failed to create department "+ e);
        }
    }

    @Override
    public void update(Department department) throws DepartmentException{
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(department);
            tx.commit();
        } catch (RuntimeException e) {
            throw new DepartmentException("failed to update department"+ e);
        }
    }

    @Override
    public void delete(Long id) throws DepartmentException{
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.remove(em.find(Department.class, id));
            tx.commit();
        } catch (RuntimeException e) {
            throw new DepartmentException("failed to delete department "+e);
        }
    }

    @Override
    public Department findDepartment(Long id) throws DepartmentException{
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Department.class, id);
        } catch (RuntimeException e) {
            throw new DepartmentException("failed to find this department "+e);
        }
    }

    @Override
    public List<Department> departmentList() throws DepartmentException {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT d FROM Department d", Department.class).getResultList();
        } catch (RuntimeException e) {
            throw new DepartmentException("failed to get department list "+e);
        }
    }
}
