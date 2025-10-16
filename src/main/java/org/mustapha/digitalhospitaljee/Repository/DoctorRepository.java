package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.Exceptions.DoctorException;
import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.Doctor;

import java.util.List;

public interface DoctorRepository {
    void createDoctor(Doctor doctor) throws DoctorException;
    void delete(Long id) throws DoctorException;
    void update(Doctor doctor) throws DoctorException;
    List<Doctor> findAll() throws DoctorException;
    Doctor findById(Long id) throws DoctorException;
    Doctor findByEmail(String email);
}
