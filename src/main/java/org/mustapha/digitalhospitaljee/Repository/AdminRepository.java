package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.Exceptions.AdminCreationException;
import org.mustapha.digitalhospitaljee.model.Admin;

import java.util.List;

public interface AdminRepository {
    void createAdmin(Admin admin) throws AdminCreationException;
    void update(Admin admin) throws AdminCreationException;
    void delete(Long id)throws AdminCreationException;
    List<Admin> getAdminsList() throws AdminCreationException;
    Admin finfById(Long id)throws AdminCreationException;
    Admin findByEmail(String email);
}
