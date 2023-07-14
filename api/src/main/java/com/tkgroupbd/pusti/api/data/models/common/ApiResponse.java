package com.tkgroupbd.pusti.api.data.models.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    int recordCount;
    T response;
}
