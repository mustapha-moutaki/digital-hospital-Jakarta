package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.Exceptions.DepartmentException;
import org.mustapha.digitalhospitaljee.model.Department;

import java.util.List;

public interface DepartmentService {
    void create(Department department);
    void update(Department department) ;
    void delete(Long id);
    Department findDepartment(Long id);
    List<Department> departmentList();
}
