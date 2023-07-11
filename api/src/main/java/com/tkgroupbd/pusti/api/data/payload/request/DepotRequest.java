package com.tkgroupbd.pusti.api.data.payload.request;

import com.tkgroupbd.pusti.api.data.models.enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


}
