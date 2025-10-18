package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.Exceptions.RoomException;
import org.mustapha.digitalhospitaljee.model.Room;

import java.time.LocalDateTime;
import java.util.List;

public interface RoomService {

    void create(Room room) throws RoomException;

    void update(Room room) throws RoomException;

    void delete(Long id) throws RoomException;

    Room getRoomById(Long id) throws RoomException;

    List<Room> roomList() throws RoomException;

    boolean isDisponible(Long id, LocalDateTime startTime) throws RoomException;

    public List<Room> getAvailableRooms(LocalDateTime startTime) throws RoomException;
}
