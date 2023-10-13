/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.driver.domain;

// import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

import com.securitycar.securitycar.models.BaseEntity;
import com.securitycar.securitycar.models.Owner;
import com.securitycar.securitycar.models.Vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author FZHUNIO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Driver extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;
    @OneToOne(mappedBy = "driver")
    private Vehicle vehicle;
}
