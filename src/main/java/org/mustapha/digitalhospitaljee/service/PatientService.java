package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.model.Patient;

import java.util.List;

public interface PatientService {
    void savePatient(Patient patient);
    List<Patient> getAllPatients();
}
