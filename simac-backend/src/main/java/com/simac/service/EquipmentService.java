package com.simac.service;

import com.simac.dto.EquipmentDto;

import java.util.List;

public interface EquipmentService {
    List<EquipmentDto> findAll();
    EquipmentDto findById(String id);
    EquipmentDto save(EquipmentDto equipmentDto);
    EquipmentDto update(String id, EquipmentDto equipmentDto);
    void delete(String id);
}
