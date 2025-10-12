package org.mustapha.digitalhospitaljee.service.impl;

import org.mustapha.digitalhospitaljee.Exceptions.AdminCreationException;
import org.mustapha.digitalhospitaljee.Exceptions.BusinessException;
import org.mustapha.digitalhospitaljee.Repository.AdminRepository;
import org.mustapha.digitalhospitaljee.Repository.impl.AdminRepositoryImpl;
import org.mustapha.digitalhospitaljee.model.Admin;
import org.mustapha.digitalhospitaljee.validation.AdminValidator;

import java.util.List;

public class AdminServiceImpl implements AdminRepository{

    private  final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public void createAdmin(Admin admin) throws AdminCreationException {
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
       if(id <= 0) {
            throw new BusinessException("the id can not be null for delete");
       }
        adminRepository.delete(id);
    }

    @Override
    public List<Admin> getAdminsList() throws AdminCreationException {
        return adminRepository.getAdminsList();
    }

    @Override
    public Admin finfById(Long id) throws AdminCreationException {
        if(id <= 0) {
            throw new BusinessException("the id can not be null ");
        }
        return adminRepository.finfById(id);
    }
}
