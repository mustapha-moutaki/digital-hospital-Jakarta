package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.Exceptions.AdminCreationException;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.model.Person;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private final EntityManagerFactory emf;
    public AdminRepositoryImpl(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void createAdmin(Admin admin) throws AdminCreationException{
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try (em) {
            tx.begin();
            em.persist(admin);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx.isActive()) tx.rollback();
            throw new AdminCreationException("Faulted to create an admin" + e);
        }
    }

    @Override
    public void update(Admin admin) throws AdminCreationException{
        EntityManager em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(admin);
            tx.commit();
        } catch (Exception e) {
            throw  new AdminCreationException("failed to update admin "+e);
        }
    }

    @Override
    public void delete(Long id) throws AdminCreationException {
        EntityManager  em = emf.createEntityManager();
        try (em) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Admin admin1 = em.find(Admin.class, id);
            em.remove(admin1);
            tx.commit();
        } catch (RuntimeException e) {
            throw new AdminCreationException("failed to delete admin "+e);
        }
    }

    @Override
    public List<Admin> getAdminsList() throws AdminCreationException{
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
        } catch (RuntimeException e) {
            throw new AdminCreationException("failed to get list of admins "+e);
        }
    }

    @Override
    public Admin finfById(Long id) throws AdminCreationException{
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Admin.class, id);
        } catch (RuntimeException e) {
            throw new AdminCreationException("Failed to find admin "+e);
        }
    }


    @Override
        public Admin findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Admin> query = em.createQuery(
                    "SELECT a FROM Admin a WHERE a.email = :email", Admin.class
            );
            query.setParameter("email", email);
            return query.getSingleResult(); // أو getResultList().stream().findFirst().orElse(null)
        } catch (NoResultException e) {
            return null;
        } catch (RuntimeException e) {
            throw new AdminCreationException("Failed to find admin " + e);
        } finally {
            em.close();
        }
    }
//    public Admin findByEmail(String email) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            TypedQuery<Person> query = em.createQuery(
//                    "SELECT p FROM Person p WHERE p.email = :email", Person.class
//            );
//            query.setParameter("email", email);
//            Person person = query.getSingleResult();
//
//
//            if(person instanceof Admin) {
//                return (Admin) person;
//            } else {
//                return null;
//            }
//
//        } catch (NoResultException e) {
//            return null;
//        } catch (RuntimeException e) {
//            throw new AdminCreationException("Failed to find admin: " + e);
//        } finally {
//            em.close();
//        }
//    }


}
