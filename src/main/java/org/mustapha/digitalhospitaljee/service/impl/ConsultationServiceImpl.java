package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.ConsultationException;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import org.mustapha.digitalhospitaljee.service.ConsultationService;
import org.mustapha.digitalhospitaljee.service.RoomService;
import org.mustapha.digitalhospitaljee.validation.ConsultationValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultationServiceImpl implements ConsultationService {

    private final List<Consultation> consultations = new ArrayList<>();
    private final ConsultationRepository consultationRepository;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository ) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void create(Consultation consultation) throws ConsultationException {
        ConsultationValidator.validate(consultation);
        consultationRepository.create(consultation);
    }

    @Override
    public void update(Consultation consultation) throws ConsultationException {
        ConsultationValidator.validate(consultation);
        consultationRepository.update(consultation);
    }

    @Override
    public void delete(Long id) throws ConsultationException {

        consultationRepository.delete(id);
    }

    @Override
    public Consultation findConsultation(Long id) throws ConsultationException {
        return consultationRepository.getConsultationById(id);
    }

    @Override
    public List<Consultation> consultationList() throws ConsultationException {
        return consultationRepository.consultationList();
    }

    @Override
    public boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus) throws ConsultationException {
       return consultationRepository.changeStatus(consultationId, newConsultationStatus);
    }

    @Override
    public boolean canBookRoom(Long roomId, LocalDateTime startTime) throws ConsultationException {
       return consultationRepository.canBookRoom(roomId, startTime);
    }

    @Override
    public List<String> getAvailableTimesForDoctor(Long doctorId, LocalDate date) {
        List<String> allTimes = new ArrayList<>();
        for (int h = 9; h < 16; h++) {
            allTimes.add(String.format("%02d:00", h));
            allTimes.add(String.format("%02d:30", h));
        }

        List<Consultation> booked = consultationList().stream()
                .filter(c -> c.getDoctor().getId().equals(doctorId) &&
                        c.getDateTime().toLocalDate().equals(date))
                .toList();

        List<String> bookedTimes = booked.stream()
                .map(c -> c.getDateTime().toLocalTime().toString())
                .toList();

        allTimes.removeAll(bookedTimes);
        return allTimes;
    }

}
