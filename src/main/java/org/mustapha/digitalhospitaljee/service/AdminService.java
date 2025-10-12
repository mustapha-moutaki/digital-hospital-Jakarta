package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.model.Doctor;

import java.util.List;

public interface AdminService {
    void create(Doctor doctor);
    void update(Doctor doctor);
    void delete(Long id);
    List<Doctor> getAllAdmins();
    Doctor findById(Long id);
}
