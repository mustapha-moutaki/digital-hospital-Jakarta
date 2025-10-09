package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.Transaction;
import org.mustapha.digitalhospitaljee.Repository.RoomRepository;
import org.mustapha.digitalhospitaljee.model.Room;

import java.util.List;

public class RoomRepositoryImp implements RoomRepository {
    EntityManagerFactory emf;
    public RoomRepositoryImp(){
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }
    @Override
    public void create(Room room) {
        EntityManager  em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.persist(room);
            tx.commit();
        }catch (RuntimeException e){
            e.printStackTrace();
        }finally {
            em.close();
        }
    }

    @Override
    public void update(Room room) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(room);
            tx.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Room findRoom = em.find(Room.class, id);
            em.remove(findRoom);
            tx.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }

    @Override
    public Room getRoomById(Long id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Room.class, id);
        }finally {
            em.close();
        }
    }

    @Override
    public List<Room> roomList() {
        EntityManager em = emf.createEntityManager();
        try{
            return em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
        }finally {
            em.close();
        }
    }

    @Override
    public boolean isDisponible(Long id) {
        EntityManager em = emf.createEntityManager();
        try{
            Room room = em.find(Room.class, id);
            if(room == null){
                System.out.println("Room is not exist");
            }
            return room.isAvailable();

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }finally {
            em.close();
        }
    }
}
