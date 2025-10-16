package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.model.Doctor;

import java.util.List;

public interface DoctorService {
    void createDoctor(Doctor doctor);
    void updateDoctor(Doctor doctor);
    void deleteDoctor(Long id);
    List<Doctor> getAllDoctors();
    Doctor findById(Long id);
    Doctor findByEmail(String email);
}
