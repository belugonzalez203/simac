package com.simac.service.impl;

import com.simac.dto.TypeMaintenanceDto;
import com.simac.entity.TypeMaintenance;
import com.simac.mapper.TypeMaintenanceMapper;
import com.simac.repository.TypeMaintenanceRepository;
import com.simac.service.TypeMaintenanceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeMaintenanceServiceImpl implements TypeMaintenanceService {

    private final TypeMaintenanceRepository repository;

    public TypeMaintenanceServiceImpl(TypeMaintenanceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TypeMaintenanceDto> getAll() {
        return repository.findAll().stream()
                .map(TypeMaintenanceMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TypeMaintenanceDto getById(String id) {
        TypeMaintenance entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMaintenance not found"));
        return TypeMaintenanceMapper.toDto(entity);
    }

    @Override
    public TypeMaintenanceDto create(TypeMaintenanceDto dto) {
        TypeMaintenance entity = TypeMaintenanceMapper.toEntity(dto);
        repository.save(entity);
        return TypeMaintenanceMapper.toDto(entity);
    }

    @Override
    public TypeMaintenanceDto update(String id, TypeMaintenanceDto dto) {
        TypeMaintenance existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("TypeMaintenance not found"));

        existing.setName_type_maintenance(dto.getName_type_maintenance());
        repository.save(existing);
        return TypeMaintenanceMapper.toDto(existing);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
