package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.DepartmentRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.DepartmentRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Department;
import org.mustapha.digitalhospitaljee.service.DepartmentService;
import org.mustapha.digitalhospitaljee.validation.DepartmentValidator;

import java.util.List;

public class DepartmentServiecImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentServiecImpl(DepartmentRepository departmentRepository){
      this.departmentRepository =  departmentRepository;
    }

    @Override
    public void create(Department department) {
        DepartmentValidator.validate(department);
        departmentRepository.create(department);

    }

    @Override
    public void update(Department department) {
        DepartmentValidator.validate(department);
        departmentRepository.update(department);
    }

    @Override
    public void delete(Long id) {
        if(id <= 0){
            throw new BusinessException("the id can not be null");
        }
        departmentRepository.delete(id);
    }

    @Override
    public Department findDepartment(Long id) {
        if(id <= 0){
            throw new BusinessException("the id can not be null");
        }
        return departmentRepository.findDepartment(id);
    }

    @Override
    public List<Department> departmentList() {
        return departmentRepository.departmentList();
    }
}
