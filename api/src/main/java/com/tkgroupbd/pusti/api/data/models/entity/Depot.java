package com.tkgroupbd.pusti.api.data.models.entity;

import com.tkgroupbd.pusti.api.data.models.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depot {
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private String phone;

    @Enumerated(EnumType.STRING)
    private Department department;

}
