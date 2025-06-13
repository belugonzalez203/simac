package com.simac.service;

import com.simac.dto.SparePartUsedDto;

import java.util.List;

public interface SparePartUsedService {
    List<SparePartUsedDto> getAll();
    SparePartUsedDto getById(Long id);
    SparePartUsedDto create(SparePartUsedDto dto);
    SparePartUsedDto update(Long id, SparePartUsedDto dto);
    void delete(Long id);
}
