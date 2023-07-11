package com.tkgroupbd.pusti.api.service.depot;

import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.data.repository.DepotRepository;
import com.tkgroupbd.pusti.api.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepotServiceImpl implements DepotService {

    @Autowired
    DepotRepository depotRepository;


    @Override
    public MessageResponse createDepot(DepotRequest depotRequest) {
        Depot newDepot = new Depot();

        newDepot.setName(depotRequest.getName());
        newDepot.setEmail(depotRequest.getEmail());
        newDepot.setPhoneNumber(depotRequest.getPhoneNumber());
        newDepot.setSalary(depotRequest.getSalary());
        newDepot.setDepartment(depotRequest.getDepartment());

        depotRepository.save(newDepot);

        return new MessageResponse("New depot created successfully");
    }

    @Override
    public Optional<Depot> updateDepot(Integer id, DepotRequest depotRequest) throws ResourceNotFoundException {

        Optional<Depot> depot = depotRepository.findById(id);
        if (depot.isEmpty()) {
            throw new ResourceNotFoundException("Depot", "id", id);
        } else
            depot.get().setName(depotRequest.getName());
            depot.get().setEmail(depotRequest.getEmail());
            depot.get().setSalary(depotRequest.getSalary());
            depot.get().setDepartment(depotRequest.getDepartment());
            depot.get().setPhoneNumber(depotRequest.getPhoneNumber());

            depotRepository.save(depot.get());

        return depot;
    }

    @Override
    public void deleteDepot(Integer id) throws ResourceNotFoundException {
        if (depotRepository.getById(id).getId().equals(id)) {
            depotRepository.deleteById(id);
        } else throw new ResourceNotFoundException("Employee", "id", id);

    }

    @Override
    public Depot getAssainDepot(Integer id) {

     return    depotRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee", "id", id));

    }

    @Override
    public List<Depot> getAllDepot() {
        return depotRepository.findAll();
    }


}
