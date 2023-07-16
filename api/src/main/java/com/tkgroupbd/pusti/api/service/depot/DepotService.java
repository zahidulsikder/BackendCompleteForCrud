package com.tkgroupbd.pusti.api.service.depot;

import com.tkgroupbd.pusti.api.data.models.entity.Depot;
import com.tkgroupbd.pusti.api.data.payload.request.DepotRequest;
import com.tkgroupbd.pusti.api.data.payload.response.MessageResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface DepotService {
    MessageResponse createDeport(DepotRequest depotRequest);
    Optional<Depot> updateDeport(Integer id, DepotRequest depotRequest);
    void deleteDeport(Integer id);
    Depot getDeportById(Integer id);
    List<Depot> getAllDeport();

    List<Depot> findDepotWithSorting(String field);
    Page<Depot> findDepotByPagination(int offset, int pageSize);
    Page<Depot> findDepotByPaginationAndSortin(int offset, int pageSize, String field);

    List<Depot> findUserByName(String name);

}
