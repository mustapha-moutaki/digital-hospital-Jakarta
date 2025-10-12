package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Department;

public class DepartmentValidator {

    public static void validate(Department department) {
        if (department == null) {
            throw new BusinessException("Department is null");
        }

        if (department.getName() == null || department.getName().trim().isEmpty()) {
            throw new BusinessException("Department name is required");
        }

        if (department.getName().length() > 50) {
            throw new BusinessException("Department name cannot exceed 50 characters");
        }

    }
}
