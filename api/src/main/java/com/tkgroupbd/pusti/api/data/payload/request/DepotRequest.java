package com.tkgroupbd.pusti.api.data.payload.request;

import com.tkgroupbd.pusti.api.data.models.enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class DepotRequest {


    @NotBlank
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @Email
    private String email;

    @NotNull
    @NotBlank
    private double salary;

    @NotNull
    @NotBlank
    @Enumerated(EnumType.STRING)
   private Department department;





}
