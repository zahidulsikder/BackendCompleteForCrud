package com.tkgroupbd.pusti.api.service.depot;

import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import com.tkgroupbd.pusti.api.exception.ResourceNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface DepotService {

 MessageResponse createDepot(DepotRequest depotRequest);
 Optional<Depot> updateDepot(Integer id, DepotRequest depotRequest) throws ResourceNotFoundException;
 void deleteDepot(Integer id) throws ResourceNotFoundException;
 Depot getAssainDepot(Integer id);
 List<Depot> getAllDepot();

 List<Depot> findDepotWithSorting(String field);
 Page<Depot> findDepotByPagination(int offset, int pageSize);
 Page<Depot> findDepotByPaginationAndSortin(int offset, int pageSize, String field);

}
