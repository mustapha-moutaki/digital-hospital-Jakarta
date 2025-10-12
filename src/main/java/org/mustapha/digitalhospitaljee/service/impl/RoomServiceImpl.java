package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Exceptions.RoomException;
import org.mustapha.digitalhospitaljee.Repository.RoomRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.RoomRepositoryImp;
import org.mustapha.digitalhospitaljee.model.Room;
import org.mustapha.digitalhospitaljee.service.RoomService;
import org.mustapha.digitalhospitaljee.validation.RoomValidator;

import java.util.List;

public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository){
        this.roomRepository =  roomRepository;
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
        if(id <= 0){
            throw new BusinessException("the id can not be null to delete room");
        }
        roomRepository.delete(id);
    }

    @Override
    public Room getRoomById(Long id) throws RoomException {
        if(id <= 0){
            throw new BusinessException("the id can not be null to get room");
        }
        return roomRepository.getRoomById(id);
    }

    @Override
    public List<Room> roomList() throws RoomException {
        return roomRepository.roomList();
    }

    @Override
    public boolean isDisponible(Long id) throws RoomException {
        if(id <= 0){
            throw  new BusinessException(" the id can not be null ");
        }
        return roomRepository.isDisponible(id);
    }
}
