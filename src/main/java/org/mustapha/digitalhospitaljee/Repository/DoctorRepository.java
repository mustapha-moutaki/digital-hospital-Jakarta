package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.model.Consultation;
import org.mustapha.digitalhospitaljee.model.Doctor;

import java.util.List;

public interface DoctorRepository {
    void createDoctor(Doctor doctor);
    void delete(Long id);
    void update(Doctor doctor);
    List<Doctor> findAll();
    Doctor findById(Long id);
}
