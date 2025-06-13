package com.simac.service;

import com.simac.dto.TechnicianDto;

import java.util.List;

public interface TechnicianService {
    List<TechnicianDto> getAll();
    TechnicianDto getById(String id);
    TechnicianDto create(TechnicianDto dto);
    TechnicianDto update(String id, TechnicianDto dto);
    void delete(String id);
}
