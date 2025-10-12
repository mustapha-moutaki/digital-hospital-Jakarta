package org.mustapha.digitalhospitaljee.service;

import org.mustapha.digitalhospitaljee.model.Admin;

import java.util.List;

public interface AdminService {
    void create(Admin admin);
    void update(Admin admin);
    void delete(Long id);
    List<Admin> getAllAdmins();
    Admin findById(Long id);
}
