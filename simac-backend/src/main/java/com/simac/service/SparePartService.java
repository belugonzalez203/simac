package com.simac.service;

import com.simac.dto.SparePartDto;

import java.util.List;

public interface SparePartService {
    List<SparePartDto> findAll();
    SparePartDto findById(String id);
    SparePartDto save(SparePartDto dto);
    void delete(String id);
}
