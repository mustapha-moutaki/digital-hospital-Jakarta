package org.mustapha.digitalhospitaljee.Repository;

import org.mustapha.digitalhospitaljee.model.Admin;

import java.util.List;

public interface AdminRepository {
    void createAdmin(Admin admin);
    void update(Admin admin);
    void delete(Long id);
    List<Admin> getAdminsList();
    Admin finfById(Long id);

}
