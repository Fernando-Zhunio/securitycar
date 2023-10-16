/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.util.Date;

import com.securitycar.securitycar.core.driver.domain.Driver;

import lombok.Data;

/**
 *
 * @author FZHUNIO
 */
@Data
@Entity
public class Vehicle extends BaseEntity {
    @Id
    private String plate;
    private Date birthday;
    private String name;
    private String photo;
    private String color;
    private String motor;
    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
