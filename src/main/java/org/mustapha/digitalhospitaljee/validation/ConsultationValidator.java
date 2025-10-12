package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Consultation;

public class ConsultationValidator {

    public static void validate(Consultation consultation) {
        if (consultation == null) {
            throw new BusinessException("Consultation is null");
        }

        if (consultation.getDateTime() == null) {
            throw new BusinessException("Date and time of consultation is required");
        }

        if (consultation.getConsultationStatus() == null) {
            throw new BusinessException("Consultation status is required");
        }

        if (consultation.getPatient() == null) {
            throw new BusinessException("Consultation must be associated with a patient");
        }

    }
}
