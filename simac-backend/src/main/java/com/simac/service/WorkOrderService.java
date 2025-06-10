package com.simac.service;

import com.simac.dto.WorkOrderDto;

import java.util.List;
import java.util.Optional;

public interface WorkOrderService {
    WorkOrderDto save(WorkOrderDto dto);
    Optional<WorkOrderDto> findById(String id);
    List<WorkOrderDto> findAll();
    void deleteById(String id);
}
