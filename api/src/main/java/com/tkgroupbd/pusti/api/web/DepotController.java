package com.tkgroupbd.pusti.api.web;

import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.exception.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.service.depot.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/depot")
public class DepotController {

    @Autowired
    DepotService depotService;

    @PostMapping(path = "/add")
    public ResponseEntity<MessageResponse> addDepot(@RequestBody DepotRequest depot){
        MessageResponse newDepot = depotService.createDepot(depot);
        return new ResponseEntity<>(newDepot, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Depot>> getAllDepot(){
        List<Depot> depots= depotService.getAllDepot();

        return new ResponseEntity<>(depots, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteDepotId(@PathVariable("id") Integer id) throws ResourceNotFoundException{
        depotService.deleteDepot(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Depot>> updateDepot(@PathVariable Integer id, @RequestBody DepotRequest depot){

        Optional<Depot> updateDepot = depotService.updateDepot(id, depot);

        return new ResponseEntity<Optional<Depot>>(updateDepot, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Depot> getDepotById(@PathVariable("id") Integer id){
        Depot depot = depotService.getAssainDepot(id);
        return  new ResponseEntity<>(depot, HttpStatus.OK);
    }




}