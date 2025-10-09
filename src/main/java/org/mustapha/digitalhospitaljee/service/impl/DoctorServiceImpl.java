package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Repository.DoctorRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.DoctorRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Doctor;
import org.mustapha.digitalhospitaljee.service.DoctorService;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {

    //  use repository in the service
    DoctorRepository doctorRepository = new DoctorRepositoryImpl();


    @Override
    public void createDoctor(Doctor doctor) {
        doctorRepository.createDoctor(doctor);
    }

    public void updateDoctor(Doctor doctor){
          doctorRepository.update(doctor);
       }

       public void deleteDoctor(Long id){
           doctorRepository.delete(id);
       }

        public List<Doctor> getAllDoctors(){
            return doctorRepository.findAll();
        }

        public Doctor findDoctorById(Long id){
        return doctorRepository.findById(id);
        }



}
