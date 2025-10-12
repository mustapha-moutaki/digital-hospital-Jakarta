package org.mustapha.digitalhospitaljee.Repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.mustapha.digitalhospitaljee.Exceptions.RoomException;
import org.mustapha.digitalhospitaljee.Repository.RoomRepository;
import org.mustapha.digitalhospitaljee.model.Room;

import java.util.List;

public class RoomRepositoryImp implements RoomRepository {

    private final EntityManagerFactory emf;

    public RoomRepositoryImp() {
        emf = Persistence.createEntityManagerFactory("hospitalPU");
    }

    @Override
    public void create(Room room) throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.persist(room);
                tx.commit();
            } catch (RuntimeException e) {
                if (tx.isActive()) tx.rollback();
                throw new RoomException("Failed to create new room: " + e);
            }
        }
    }

    @Override
    public void update(Room room) throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                em.merge(room);
                tx.commit();
            } catch (RuntimeException e) {
                if (tx.isActive()) tx.rollback();
                throw new RoomException("Failed to update room: " +e);
            }
        }
    }

    @Override
    public void delete(Long id) throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Room findRoom = em.find(Room.class, id);
                if (findRoom != null) {
                    em.remove(findRoom);
                } else {
                    throw new RoomException("Room with id " + id + " does not exist");
                }
                tx.commit();
            } catch (RuntimeException e) {
                if (tx.isActive()) tx.rollback();
                throw new RoomException("Failed to remove room: " +e);
            }
        }
    }

    @Override
    public Room getRoomById(Long id) throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            return em.find(Room.class, id);
        } catch (RuntimeException e) {
            throw new RoomException("Failed to get room by id: " + e);
        }
    }

    @Override
    public List<Room> roomList() throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            return em.createQuery("SELECT r FROM Room r", Room.class).getResultList();
        } catch (RuntimeException e) {
            throw new RoomException("Failed to get room list: " + e);
        }
    }

    @Override
    public boolean isDisponible(Long id) throws RoomException {
        try (EntityManager em = emf.createEntityManager()) {
            Room room = em.find(Room.class, id);
            if (room == null) {
                throw new RoomException("Room with id " + id + " does not exist");
            }
            return room.isAvailable();
        } catch (RuntimeException e) {
            throw new RoomException("Failed to get room status: " +e);
        }
    }
}
