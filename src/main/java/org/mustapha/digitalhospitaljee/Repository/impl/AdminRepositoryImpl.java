package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.*;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.model.Admin;

import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    EntityManagerFactory emf;
    public AdminRepositoryImpl(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void createAdmin(Admin admin) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(admin);
            tx.commit();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void update(Admin admin) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(admin);
            tx.commit();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager  em = emf.createEntityManager();
        EntityTransaction tx= em.getTransaction();
        try{
            tx.begin();
            Admin admin1 = em.find(Admin.class, id);
            em.remove(admin1);
            tx.commit();
        }finally {
            em.close();
        }
    }

    @Override
    public List<Admin> getAdminsList() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT a FROM Admin a", Admin.class).getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public Admin finfById(Long id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Admin.class, id);
        }finally {
            em.close();
        }
    }
}
