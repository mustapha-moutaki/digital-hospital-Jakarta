package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Patient;

public class PatientValidator {

    public static void validatePatient(Patient patient) {
        if (patient == null) {
            throw new BusinessException("Patient is null");
        }

        if (patient.getFirstName() == null || patient.getFirstName().trim().isEmpty()) {
            throw new BusinessException("First name cannot be empty");
        }

        if (patient.getLastname() == null || patient.getLastname().trim().isEmpty()) {
            throw new BusinessException("Last name cannot be empty");
        }

        if (patient.getTall() == 0) {
            throw new BusinessException("Tall cannot be zero");
        }

        if (patient.getWeight() == 0) {
            throw new BusinessException("Weight cannot be zero");
        }

    }
}
