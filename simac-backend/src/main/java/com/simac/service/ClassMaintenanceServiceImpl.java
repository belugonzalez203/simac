package com.simac.service;

import com.simac.dto.ClassMaintenanceDto;
import com.simac.entity.ClassMaintenance;
import com.simac.mapper.ClassMaintenanceMapper;
import com.simac.repository.ClassMaintenanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassMaintenanceServiceImpl implements ClassMaintenanceService {

    private final ClassMaintenanceRepository repository;
    private final ClassMaintenanceMapper mapper;

    public ClassMaintenanceServiceImpl(ClassMaintenanceRepository repository, ClassMaintenanceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ClassMaintenanceDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClassMaintenanceDto findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public ClassMaintenanceDto save(ClassMaintenanceDto dto) {
        ClassMaintenance entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public ClassMaintenanceDto update(ClassMaintenanceDto dto) {
        ClassMaintenance entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
