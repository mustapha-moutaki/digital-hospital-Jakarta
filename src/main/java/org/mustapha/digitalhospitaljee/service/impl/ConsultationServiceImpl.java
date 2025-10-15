package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.ConsultationRepository;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.enums.ConsultationStatus;
import org.mustapha.digitalhospitaljee.service.ConsultationService;
import org.mustapha.digitalhospitaljee.validation.ConsultationValidator;

import java.util.List;

public class ConsultationServiceImpl implements ConsultationService {
    private final ConsultationRepository consultationRepository;

    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public void creaete(Consultation consultation) {
        ConsultationValidator.validate(consultation);
        consultationRepository.create(consultation);
    }

    @Override
    public void update(Consultation consultation) {
        ConsultationValidator.validate(consultation);
        consultationRepository.update(consultation);
    }

    @Override
    public void delete(Long id) {
        if(id <= 0){
            throw new BusinessException("the id can not be null ");
        }
        consultationRepository.delete(id);
    }

    @Override
    public Consultation findConsultation(Long id) {
        if(id <= 0){
            throw new BusinessException("the id can not be null ");
        }
       return  consultationRepository.findConsultation(id);
    }

    @Override
    public List<Consultation> consultationList() {
        return  consultationRepository.consultationList();
    }

        @Override
        public boolean changeStatus(Long consultationId, ConsultationStatus newConsultationStatus) {
            if (consultationId == null || consultationId <= 0) {
                throw new BusinessException("Invalid consultation ID");
            }
            if (newConsultationStatus == null) {
                throw new BusinessException("New consultation status cannot be null");
            }

//            Consultation consultation = consultationRepository.findConsultation(consultationId);
//            consultation.setConsultationStatus(newConsultationStatus);
            consultationRepository.changeStatus(consultationId, newConsultationStatus);
            return true;
        }
}
