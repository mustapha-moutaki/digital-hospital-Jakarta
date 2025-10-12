package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.Exceptions.ConsultationExceptions;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import java.lang.module.Configuration;
import java.util.List;

public interface ConsultationRepository {
    void create(Consultation consultation) throws ConsultationExceptions;
    void update(Consultation consultation) throws ConsultationExceptions;
    void delete(Long id)throws ConsultationExceptions;
    Consultation findConsultation(Long id)throws ConsultationExceptions;
    List<Consultation> consultationList()throws ConsultationExceptions;
    boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus) throws ConsultationExceptions;
}
