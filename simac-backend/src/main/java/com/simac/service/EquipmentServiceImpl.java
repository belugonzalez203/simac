package com.simac.service;

import com.simac.dto.EquipmentDto;
import com.simac.entity.Equipment;
import com.simac.mapper.EquipmentMapper;
import com.simac.repository.EquipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepository equipmentRepository;
    private final EquipmentMapper mapper;

    public EquipmentServiceImpl(EquipmentRepository equipmentRepository, EquipmentMapper mapper) {
        this.equipmentRepository = equipmentRepository;
        this.mapper = mapper;
    }

    @Override
    public List<EquipmentDto> findAll() {
        return equipmentRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EquipmentDto findById(String id) {
        return equipmentRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Equipment not found with id: " + id));
    }

    @Override
    public EquipmentDto save(EquipmentDto equipmentDto) {
        Equipment entity = mapper.toEntity(equipmentDto);
        Equipment saved = equipmentRepository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public EquipmentDto update(String id, EquipmentDto equipmentDto) {
        if (!equipmentRepository.existsById(id)) {
            throw new RuntimeException("Equipment not found with id: " + id);
        }

        Equipment entity = mapper.toEntity(equipmentDto);
        entity.setId_equipment(id);
        Equipment updated = equipmentRepository.save(entity);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(String id) {
        if (!equipmentRepository.existsById(id)) {
            throw new RuntimeException("Equipment not found with id: " + id);
        }
        equipmentRepository.deleteById(id);
    }
}
