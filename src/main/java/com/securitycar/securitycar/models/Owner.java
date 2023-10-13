/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.securitycar.securitycar.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.util.Date;

import core.driver.domain.Driver;
import lombok.Data;

/**
 *
 * @author FZHUNIO
 */
@Data
@Entity
public class Owner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String firtsname;
    private Date birthday;
    private String lastname;
    private String photo;
    private String docType;
    private String docNumber;
    @OneToOne(mappedBy = "owner")
    private Driver driver;
}
