package com.simac.service;

import com.simac.dto.ClassMaintenanceDto;
import java.util.List;

public interface ClassMaintenanceService {
    List<ClassMaintenanceDto> findAll();
    ClassMaintenanceDto findById(String id);
    ClassMaintenanceDto save(ClassMaintenanceDto dto);
    ClassMaintenanceDto update(ClassMaintenanceDto dto);
    void delete(String id);
}

