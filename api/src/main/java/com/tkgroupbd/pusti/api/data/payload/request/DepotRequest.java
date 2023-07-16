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
    @NotNull
    private String name;
    @Email
    private String email;
    @NotBlank
    @NotNull
    private String phone;
    @NotBlank
    @NotNull
    @Enumerated(EnumType.STRING)
    private Department department;

}
