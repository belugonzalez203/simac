package com.simac.service;

import com.simac.dto.AreaDto;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    List<AreaDto> findAll();
    Optional<AreaDto> findById(String id);
    AreaDto save(AreaDto dto);
    AreaDto update(AreaDto dto);
    void delete(String id);
}
