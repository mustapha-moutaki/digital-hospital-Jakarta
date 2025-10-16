package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.PatientRepository;
import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.model.Patient;
import org.mustapha.digitalhospitaljee.service.PatientService;
import org.mustapha.digitalhospitaljee.validation.PatientValidator;

import java.util.List;

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public void craete(Patient patient) {
        PatientValidator.validatePatient(patient);
        patientRepository.createPatient(patient);
    }


    @Override
    public void update(Patient patient) {
        if (patient == null || patient.getId() == null) {
            throw new BusinessException("Patient or patient ID cannot be null for update");
        }

        PatientValidator.validatePatient(patient);
        patientRepository.update(patient);
    }


    @Override
    public void delete(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException("Invalid patient ID for deletion");
        }

        Patient existing = patientRepository.findById(id);
        if (existing == null) {
            throw new BusinessException("Patient with ID " + id + " not found");
        }

        patientRepository.delete(id);
    }

    @Override
    public Patient findById(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException("Invalid patient ID");
        }

        Patient patient = patientRepository.findById(id);
        if (patient == null) {
            throw new BusinessException("Patient not found with ID: " + id);
        }

        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();

    }


    @Override
    public List<Patient> getAllByDoctorId(Long id) {
        return patientRepository.getAllByDoctorId(id);
    }

    @Override
    public Patient findByEmail(String email) {
        return  patientRepository.findByEmail(email);
    }
}
