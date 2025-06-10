package com.simac.service;

import com.simac.dto.SupportTechnicianDto;

import java.util.List;

public interface SupportTechnicianService {
    List<SupportTechnicianDto> getAll();
    SupportTechnicianDto getById(String id);
    SupportTechnicianDto create(SupportTechnicianDto dto);
    SupportTechnicianDto update(String id, SupportTechnicianDto dto);
    void delete(String id);
}
