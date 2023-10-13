package com.securitycar.securitycar.dtos.Driver;

import java.util.Date;

import com.securitycar.securitycar.models.Owner;
import com.securitycar.securitycar.models.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestDriverDto {
    private String id;
    @NotBlank
    private String firtsname;
    @NotBlank
    private Date birthday;
    @NotBlank
    private String lastname;
    @NotBlank
    private String photo;
    @NotBlank
    private String docType;
    @NotBlank
    private String docNumber;
    @NotBlank
    private Integer isOwnerVehicle;
    @NotBlank
    private String country;
    @NotBlank
    private String state;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
    @NotBlank
    private String number;
    @NotBlank
    private String postalCode;
    private Owner owner;
    @NotBlank
    private Vehicle vehicle;
}
