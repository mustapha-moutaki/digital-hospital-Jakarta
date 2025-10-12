package org.mustapha.digitalhospitaljee.validation;

import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.model.Admin;

public class AdminValidator {

    public static void validate(Admin admin) {
        if (admin == null) {
            throw new BusinessException("Admin is null");
        }

        if (admin.getFirstName() == null || admin.getFirstName().trim().isEmpty()) {
            throw new BusinessException("Admin first name cannot be empty");
        }

        if (admin.getLastname() == null || admin.getLastname().trim().isEmpty()) {
            throw new BusinessException("Admin last name cannot be empty");
        }

        if (admin.getEmail() == null || admin.getEmail().trim().isEmpty()) {
            throw new BusinessException("Admin email cannot be empty");
        }

        if (admin.getPassword() == null || admin.getPassword().trim().isEmpty()) {
            throw new BusinessException("Admin password cannot be empty");
        }

        if (admin.getPassword().length() < 6) {
            throw new BusinessException("Admin password must be at least 6 characters");
        }
    }
}
