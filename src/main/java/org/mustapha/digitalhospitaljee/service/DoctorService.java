package org.mustapha.digitalhospitaljee.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mustapha.digitalhospitaljee.model.Doctor;

import java.util.List;

public class DoctorService {
    private EntityManagerFactory emf;

    public DoctorService(){
       emf =Persistence.createEntityManagerFactory("hospitalPU");
    }


        public void createDocotr(Doctor doctor){
            EntityManager em = emf.createEntityManager();
            try (em) {
                EntityTransaction tx = em.getTransaction();
                tx.begin();
                em.persist(doctor);
                tx.commit();
            }
        }

       public void updateDoctor(Doctor doctor){
            EntityManager em = emf.createEntityManager();
           try (em) {
               EntityTransaction tx = em.getTransaction();
               tx.begin();
               em.merge(doctor);// update
               tx.commit();
           } catch (Exception e) {
               e.printStackTrace();
           }
       }

       public void deleteDoctor(Long id){
            EntityManager em = emf.createEntityManager();
           try (em) {
               EntityTransaction tx = em.getTransaction();
               tx.begin();
               Doctor doctor = em.find(Doctor.class, id);// to return the doctor
               if (doctor != null) {
                   em.remove(doctor);//delete
               }
               tx.commit();
           }
       }

        public List<Doctor> getAllDoctors(){
            try (EntityManager em = emf.createEntityManager()) {
                return em.createQuery("SELECT d FROM Doctor d", Doctor.class).getResultList();
            }
        }

//        public Doctor getDoctorById(Long id){
//            EntityManager em = emf.createEntityManager();
//            try{
//                Doctor doctor = em.find(Doctor.class , id);
//                if(doctor != null){
//
//                }
//            }
//        }

    public void close(){
            if(emf.isOpen()){
                emf.close();
            }
    }

}
