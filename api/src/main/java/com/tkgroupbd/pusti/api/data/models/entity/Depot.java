package com.tkgroupbd.pusti.api.data.models.entity;

import com.tkgroupbd.pusti.api.data.models.common.Sample;
import com.tkgroupbd.pusti.api.data.models.enums.Department;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Depot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private double salary;

    @Enumerated(EnumType.STRING)
    private Department department;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Sample{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Double.compare(depot.salary, salary) == 0 && Objects.equals(id, depot.id) && Objects.equals(name, depot.name) && Objects.equals(phoneNumber, depot.phoneNumber) && Objects.equals(email, depot.email) && department == depot.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, salary, department);
    }


}
