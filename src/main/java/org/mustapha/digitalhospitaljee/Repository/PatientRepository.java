package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.Exceptions.PatientException;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.model.Patient;

import java.util.List;

public interface PatientRepository {
    void createPatient(Patient patient) throws PatientException;
    void delete(Long id)throws PatientException;
    void update(Patient patient) throws PatientException;
    List<Patient> findAll() throws PatientException;
    Patient findById(Long id) throws PatientException;
}
