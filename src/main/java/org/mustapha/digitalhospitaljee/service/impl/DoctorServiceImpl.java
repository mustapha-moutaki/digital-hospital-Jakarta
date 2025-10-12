package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DoctorService;
import org.mustapha.digitalhospitaljee.validation.DoctorValidator;

import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    @Override
    public void createDoctor(Doctor doctor) {
        DoctorValidator.validate(doctor);
        doctorRepository.createDoctor(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        if (doctor == null || doctor.getId() == null) {
            throw new BusinessException("Doctor or ID cannot be null for update");
        }
        DoctorValidator.validate(doctor);
        doctorRepository.update(doctor);
    }

    @Override
    public void deleteDoctor(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException("Invalid doctor ID for deletion");
        }
        doctorRepository.delete(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(Long id) {
        if (id == null || id <= 0) {
            throw new BusinessException("Invalid doctor ID");
        }
        return doctorRepository.findById(id);
    }

    public Doctor findDoctorById(Long id) {
        return findById(id);
    }
}
