/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import core.driver.domain.Driver;

/**
 *
 * @author FZHUNIO
 */
public interface DriverRepository extends JpaRepository<Driver, String> {

}