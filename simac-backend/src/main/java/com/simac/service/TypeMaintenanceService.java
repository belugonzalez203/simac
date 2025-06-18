package com.simac.service;

import com.simac.dto.TypeMaintenanceDto;

import java.util.List;

public interface TypeMaintenanceService {
    List<TypeMaintenanceDto> getAll();
    TypeMaintenanceDto getById(String id);
    TypeMaintenanceDto create(TypeMaintenanceDto dto);
    TypeMaintenanceDto update(String id, TypeMaintenanceDto dto);
    void delete(String id);
}
