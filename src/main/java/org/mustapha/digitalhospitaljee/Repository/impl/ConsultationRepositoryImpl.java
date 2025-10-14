package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mustapha.digitalhospitaljee.Exceptions.ConsultationExceptions;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import java.util.List;

public class ConsultationRepositoryImpl implements ConsultationRepository {

    private final EntityManagerFactory emf;

    public ConsultationRepositoryImpl() {
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void create(Consultation consultation) throws ConsultationExceptions {
        EntityManager em = emf.createEntityManager();
        try(em){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(consultation);
            tx.commit();
        } catch (RuntimeException e) {
            throw new ConsultationExceptions("Failed to create Consultation "+e);
        }
    }

    @Override
    public void update(Consultation consultation) throws ConsultationExceptions{
        EntityManager  em = emf.createEntityManager();

        try(em){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.merge(consultation);
            tx.commit();
        } catch (RuntimeException e) {
            throw new ConsultationExceptions("Failed to update the Consultation "+ e);
        }
    }

    @Override
    public void delete(Long id) throws ConsultationExceptions{
        EntityManager em = emf.createEntityManager();
        try(em){
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            Consultation consultation = em.find(Consultation.class, id);
            if(consultation != null){
                em.remove(consultation);
            }else{
                throw new ConsultationExceptions("the consultaion is not exist ");
            }
        } catch (RuntimeException e) {
            throw new ConsultationExceptions("Failed to delete Consultation " + e);
        }
    }

    @Override
    public Consultation findConsultation(Long id) throws ConsultationExceptions{
        EntityManager em = emf.createEntityManager();
        try(em){
           return em.find(Consultation.class, id);
        } catch (RuntimeException e) {
            throw new ConsultationExceptions("failed to find this consultation "+ e);
        }
    }

    @Override
    public List<Consultation> consultationList() throws ConsultationExceptions{
        EntityManager em = emf.createEntityManager();

        try(em){
            return em.createQuery("SELECT c FROM Consultation c JOIN FETCH c.doctor d JOIN FETCH c.patient p", Consultation.class).getResultList();
        } catch (RuntimeException e) {
            throw new ConsultationExceptions("failed to get list of consultations "+e);
        }
    }

    @Override
    public boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus) throws ConsultationExceptions {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Consultation consultation = em.find(Consultation.class, consultationId);
            if (consultation == null) {
                throw new ConsultationExceptions("Failed to find the consultation with ID: " + consultationId);
            }

            consultation.setConsultationStatus(newConsultationStatus);
            em.merge(consultation);

            tx.commit();
            return true;

        } catch (RuntimeException e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw new ConsultationExceptions("Failed to change status: " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
