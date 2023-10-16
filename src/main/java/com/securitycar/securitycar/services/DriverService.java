/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.services;

import com.securitycar.securitycar.core.driver.domain.Driver;
import com.securitycar.securitycar.repositories.DriverRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FZHUNIO
 */
@Service
public class DriverService implements IDriverService {

    @Autowired
    private DriverRepository driverRepository;

    @Override
    public List<Driver> list() {
        var list = driverRepository.findAll();
        return list;
    }

    @Override
    public Driver find(String id) {
        Driver driver = this.driverRepository.findById(id).orElse(null);
        return driver;
    }

    @Override
    public void save(Driver driver) {
        this.driverRepository.save(driver);
    }

    @Override
    public void destroy(String id) {
        this.driverRepository.deleteById(id);
    }

}
