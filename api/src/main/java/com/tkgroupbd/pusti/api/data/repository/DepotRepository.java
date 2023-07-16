package com.tkgroupbd.pusti.api.data.repository;


import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepotRepository extends JpaRepository<Depot,Integer> {
    List<Depot> findByNameContaining(String name);


}
