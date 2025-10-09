package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.model.Room;

import java.util.List;

public interface RoomRepository {
    void create(Room room);
    void update(Room room);
    void delete(Long id);
    Room getRoomById(Long id);
    List<Room> roomList();
    boolean isDisponible(Long id);
}
