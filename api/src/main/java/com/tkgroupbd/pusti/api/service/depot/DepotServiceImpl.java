package com.tkgroupbd.pusti.api.service.depot;

import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.models.enums.Department;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repository.DepotRepository;
import com.tkgroupbd.pusti.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DepotServiceImpl implements DepotService{

    public static final  String HASH_KEY = "Depot";

    @Autowired
    DepotRepository depotRepository;

    @Override
    public MessageResponse createDeport(DepotRequest depotRequest) {
        Depot newDepot = new Depot();
        newDepot.setName(depotRequest.getName());
        newDepot.setEmail(depotRequest.getEmail());
        newDepot.setPhone(depotRequest.getPhone());
        newDepot.setDepartment(depotRequest.getDepartment());
        depotRepository.save(newDepot);
        return new MessageResponse("New Deport created successfully");
    }

    @Override
    public Optional<Depot> updateDeport(Integer id, DepotRequest depotRequest) {
        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isEmpty()){
            throw new ResourceNotFoundException("Depot", "id", id);
        }
        else
            depot.get().setName(depotRequest.getName());
        depot.get().setEmail(depotRequest.getEmail());
        depot.get().setPhone(depotRequest.getPhone());
        depot.get().setDepartment(depotRequest.getDepartment());
        depotRepository.save(depot.get());
        return depot;
    }

    @Override
    public void deleteDeport(Integer id) {
        depotRepository.deleteById(id);

    }

    @Override
    public Depot getDeportById(Integer id) {
        System.out.println(" called getDeportById() from db" );
        return depotRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Deport", "id", id));
    }

    @Override
    public List<Depot> getAllDeport() {
        return depotRepository.findAll();
    }


    @Override
    public List<Depot> findDepotWithSorting(String field) {
        return  depotRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }


    @Override
    public Page<Depot> findDepotByPagination(int offset, int pageSize){
        Page<Depot> depots = depotRepository.findAll(PageRequest.of(offset, pageSize));
        return depots;

    }

    @Override
    public Page<Depot> findDepotByPaginationAndSortin(int offset, int pageSize, String field){
        Page<Depot> depots = depotRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return depots;

    }

    @Override
    public List<Depot> findUserByName(String name) {
        List<Depot> depotsName= depotRepository.findByNameContaining(name);
        return depotsName;
    }


    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    public void seedUsersTable() {
        if (depotRepository.count()==0){
            Depot depot = new Depot();
            depot.setName("admin");
            depot.setEmail("admin@gmail.com");
            depot.setPhone("01234567891");
            depot.setDepartment(Department.valueOf("MARKETING"));
            depotRepository.save(depot);
        }else {
            System.out.println("Users Seeding Not Required");
        }
    }



}
