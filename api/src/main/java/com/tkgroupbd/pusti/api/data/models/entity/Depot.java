package com.tkgroupbd.pusti.api.data.models.entity;

import com.tkgroupbd.pusti.api.data.models.common.Sample;
import com.tkgroupbd.pusti.api.data.models.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
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





}
