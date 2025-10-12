package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Room;

public class RoomValidator {

    public static void validate(Room room) {
        if (room == null) {
            throw new BusinessException("Room is null");
        }

        if (room.getName() == null || room.getName().trim().isEmpty()) {
            throw new BusinessException("Room name is required");
        }

        if (room.getName().length() > 30) {
            throw new BusinessException("Room name cannot exceed 30 characters");
        }

        if (room.getCapacity() <= 0) {
            throw new BusinessException("Room capacity must be greater than 0");
        }

        if (room.getCapacity() > 55) {
            throw new BusinessException("Room capacity cannot exceed 55");
        }

        if (room.getDepartment() == null) {
            throw new BusinessException("Room must belong to a department");
        }
    }
}
