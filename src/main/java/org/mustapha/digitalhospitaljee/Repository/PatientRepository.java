package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Patient;

import java.util.List;

public interface PatientRepository {
    void createPatient(Patient patient);
    void delete(Long id);
    void update(Patient patient);
    List<Patient> findAll();
    Patient findById(Long id);
}
