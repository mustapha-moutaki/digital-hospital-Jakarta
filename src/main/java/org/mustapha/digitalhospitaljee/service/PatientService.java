package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.model.Patient;

import java.util.List;

public interface PatientService {
    void craete(Patient patient);
    void update(Patient patient);
    void delete(Long id);
    Patient findById(Long id);
    List<Patient> getAllPatients();
    List<Patient> getAllByDoctorId(Long id);
}
