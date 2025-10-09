package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.model.Department;

import java.util.List;

public interface DepartmentRepository {
    void create(Department department);
    void update(Department department);
    void delete(Long id);
    Department findDepartment(Long id);
    List<Department>departmentList();
}
