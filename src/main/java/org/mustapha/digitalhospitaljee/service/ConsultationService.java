package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.Exceptions.ConsultationException;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ConsultationService {

    void create(Consultation consultation) throws ConsultationException;

    void update(Consultation consultation) throws ConsultationException;

    void delete(Long id) throws ConsultationException;

    Consultation findConsultation(Long id) throws ConsultationException;

    List<Consultation> consultationList() throws ConsultationException;

    boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus) throws ConsultationException;

    boolean canBookRoom(Long roomId, LocalDateTime startTime) throws ConsultationException;

    public List<String> getAvailableTimesForDoctor(Long doctorId, LocalDate date);
}
