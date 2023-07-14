package com.tkgroupbd.pusti.api.web;

import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.exception.ResourceNotFoundException;
import com.tkgroupbd.pusti.api.service.depot.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/{field}")
    private ApiResponse<List<Depot>> getProductsWithSort(@PathVariable String field) {
        List<Depot> allProducts = depotService.findDepotWithSorting(field);
        return new ApiResponse(allProducts.size(), allProducts);
    }

    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<Depot>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Depot> depotWithPagination = depotService.findDepotByPagination(offset, pageSize);
        return new ApiResponse(depotWithPagination.getSize(), depotWithPagination);
    }


    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<Depot>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Depot> depotWithPagination = depotService.findDepotByPaginationAndSortin(offset, pageSize, field);
        return new ApiResponse(depotWithPagination.getSize(), depotWithPagination);
    }



}
