/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.services;

import java.util.List;

import com.securitycar.securitycar.core.driver.domain.Driver;

/**
 *
 * @author FZHUNIO
 */
public interface IDriverService {
    public List<Driver> list();

    public Driver find(String id);

    public void save(Driver driver);

    public void destroy(String id);
}