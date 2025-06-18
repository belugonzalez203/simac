package com.simac.service;

import com.simac.dto.SupportTechnicianDto;
import com.simac.entity.SupportTechnician;
import com.simac.mapper.SupportTechnicianMapper;
import com.simac.repository.SupportTechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupportTechnicianServiceImpl implements SupportTechnicianService {

    private final SupportTechnicianRepository repository;

    public SupportTechnicianServiceImpl(SupportTechnicianRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SupportTechnicianDto> getAll() {
        return repository.findAll().stream()
                .map(SupportTechnicianMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SupportTechnicianDto getById(String id) {
        return repository.findById(id)
                .map(SupportTechnicianMapper::toDto)
                .orElse(null);
    }

    @Override
    public SupportTechnicianDto create(SupportTechnicianDto dto) {
        SupportTechnician entity = SupportTechnicianMapper.toEntity(dto);
        return SupportTechnicianMapper.toDto(repository.save(entity));
    }

    @Override
    public SupportTechnicianDto update(String id, SupportTechnicianDto dto) {
        if (!repository.existsById(id)) return null;
        SupportTechnician entity = SupportTechnicianMapper.toEntity(dto);
        entity.setId_support(id);
        return SupportTechnicianMapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
