package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.Exceptions.DepartmentException;
import org.mustapha.digitalhospitaljee.model.Department;

import java.util.List;

public interface DepartmentRepository {

    void create(Department department) throws DepartmentException;
    void update(Department department) throws DepartmentException;
    void delete(Long id) throws DepartmentException;
    Department findDepartment(Long id) throws DepartmentException;
    List<Department>departmentList() throws DepartmentException;
}
