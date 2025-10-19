package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.RoomException;
import org.mustapha.digitalhospitaljee.Repository.RoomRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.RoomRepositoryImp;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.Room;
import org.mustapha.digitalhospitaljee.service.ConsultationService;
import org.mustapha.digitalhospitaljee.service.RoomService;
import org.mustapha.digitalhospitaljee.validation.RoomValidator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;
    private final ConsultationService consultationService;

    public RoomServiceImpl(RoomRepository roomRepository, ConsultationService consultationService){
        this.roomRepository = new RoomRepositoryImp();
        this.consultationService = consultationService;
    }

    @Override
    public void create(Room room) throws RoomException {
        RoomValidator.validate(room);
        roomRepository.create(room);
    }

    @Override
    public void update(Room room) throws RoomException {
        RoomValidator.validate(room);
        roomRepository.update(room);
    }

    @Override
    public void delete(Long id) throws RoomException {
        roomRepository.delete(id);
    }

    @Override
    public Room getRoomById(Long id) throws RoomException {
        return roomRepository.getRoomById(id);
    }

    @Override
    public List<Room> roomList() throws RoomException {
        return roomRepository.roomList();
    }

    @Override
    public boolean isDisponible(Long id, LocalDateTime startTime) throws RoomException {
        return  roomRepository.isDisponible(id, startTime);
    }

    @Override
    public List<Room> getAvailableRooms(LocalDateTime startTime) throws RoomException {
        List<Room> allRooms = roomList();
        List<Room> bookedRooms = consultationService.consultationList().stream()
                .filter(c -> c.getDateTime().equals(startTime))
                .map(Consultation::getRoom)
                .toList();
        allRooms.removeAll(bookedRooms);
        return allRooms;
    }


}
