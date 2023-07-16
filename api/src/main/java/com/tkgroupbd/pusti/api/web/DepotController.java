package com.tkgroupbd.pusti.api.web;
import com.tkgroupbd.pusti.api.data.models.common.ApiResponse;
import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.service.depot.DepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/depot")
@EnableCaching
public class DepotController {
    @Autowired
    DepotService depotService;

    //Get All Data  API


    @GetMapping("/all")
    public ResponseEntity<List<Depot>> getAllDeports () {
        List<Depot> depots = depotService.getAllDeport();
        return new ResponseEntity<>(depots, HttpStatus.OK);
    }
    //Create API
    @PostMapping("/add")
    @Cacheable(value = "depots")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody DepotRequest depotRequest) {
        MessageResponse newDeport = depotService.createDeport(depotRequest);
        return new ResponseEntity<>(newDeport, HttpStatus.CREATED);
    }
    //Delete By Id API
    @DeleteMapping("/delete/{id}")
    @CacheEvict(key = "#id", value = "Depot")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Integer id) {
        depotService.deleteDeport(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Find by id Api
    @GetMapping("/find/{id}")
    @Cacheable(key = "#id", value = "Depot")
    public ResponseEntity<Depot> getDeportById (@PathVariable("id") Integer id) {
        Depot depot = depotService.getDeportById(id);
        System.out.println("----------------------------------------------");
        return new ResponseEntity<>(depot, HttpStatus.OK);
    }

    //Update Api
    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<Depot>> updateEmployee(@PathVariable Integer id, @RequestBody DepotRequest depotRequest) {
        Optional<Depot> updateDeport = depotService.updateDeport(id, depotRequest);
        return new ResponseEntity<Optional<Depot>>(updateDeport, HttpStatus.OK);
    }

    // Sorting data by field name
    @GetMapping("/{field}")
    private ApiResponse<List<Depot>> getProductsWithSort(@PathVariable String field) {
        List<Depot> allDepots = depotService.findDepotWithSorting(field);
        return new ApiResponse(allDepots.size(), allDepots);
    }

    //pagination data as user's selcetion
    @GetMapping("/pagination/{offset}/{pageSize}")
    private ApiResponse<Page<Depot>> getProductsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<Depot> depotWithPagination = depotService.findDepotByPagination(offset, pageSize);
        return new ApiResponse(depotWithPagination.getSize(), depotWithPagination);
    }


    //pagination and sorting data as user's selection
    @GetMapping("/paginationAndSort/{offset}/{pageSize}/{field}")
    private ApiResponse<Page<Depot>> getProductsWithPaginationAndSort(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
        Page<Depot> depotWithPagination = depotService.findDepotByPaginationAndSortin(offset, pageSize, field);
        return new ApiResponse(depotWithPagination.getSize(), depotWithPagination);
    }


    @GetMapping("/search/{name}")
    private List<Depot> findUserByName(@PathVariable String name ) {
        List<Depot> allDepots = depotService.findUserByName(name);
        return allDepots;
    }




}
