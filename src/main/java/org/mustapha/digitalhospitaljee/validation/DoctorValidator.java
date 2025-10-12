package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Doctor;

public class DoctorValidator {

    public static void validate(Doctor doctor) {
        if (doctor == null) {
            throw new BusinessException("Doctor is null");
        } else if (doctor.getFirstName() == null || doctor.getFirstName().trim().isEmpty()) {
            throw new BusinessException("Doctor first name cannot be empty");
        } else if (doctor.getLastname() == null || doctor.getLastname().trim().isEmpty()) {
            throw new BusinessException("Doctor last name cannot be empty");
        } else if (doctor.getSpecialist() == null || doctor.getSpecialist().trim().isEmpty()) {
            throw new BusinessException("Doctor speciality cannot be empty");
        } else if (doctor.getEmail() == null || doctor.getEmail().trim().isEmpty()) {
            throw new BusinessException("Doctor email cannot be empty");
        }
    }
}
