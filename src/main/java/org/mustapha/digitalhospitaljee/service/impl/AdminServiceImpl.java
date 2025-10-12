package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.AdminCreationException;
import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.service.AdminService;
import org.mustapha.digitalhospitaljee.validation.AdminValidator;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public void create(Admin admin) throws AdminCreationException {
        AdminValidator.validate(admin);
        adminRepository.createAdmin(admin);
    }

    @Override
    public void update(Admin admin) throws AdminCreationException {
        AdminValidator.validate(admin);
        adminRepository.update(admin);
    }

    @Override
    public void delete(Long id) throws AdminCreationException {
        if(id == null || id <= 0){
            throw new BusinessException("ID must be positive and not null");
        }
        adminRepository.delete(id);
    }

    @Override
    public List<Admin> getAllAdmins() throws AdminCreationException {
        return adminRepository.getAdminsList();
    }

    @Override
    public Admin findById(Long id) throws AdminCreationException {
        if(id == null || id <= 0){
            throw new BusinessException("ID must be positive and not null");
        }
        return adminRepository.finfById(id);
    }
}
