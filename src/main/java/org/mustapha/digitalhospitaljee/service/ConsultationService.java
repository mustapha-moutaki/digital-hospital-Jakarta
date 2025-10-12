package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.Exceptions.ConsultationExceptions;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import java.util.List;

public interface ConsultationService {
    void creaete(Consultation consultation);
    void update(Consultation consultation) ;
    void delete(Long id);
    Consultation findConsultation(Long id);
    List<Consultation> consultationList();
    boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus);
}
