package com.simac.service;

import com.simac.dto.SparePartDto;
import com.simac.entity.SparePart;
import com.simac.mapper.SparePartMapper;
import com.simac.repository.SparePartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartServiceImpl implements SparePartService {

    private final SparePartRepository repository;
    private final SparePartMapper mapper;

    public SparePartServiceImpl(SparePartRepository repository, SparePartMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<SparePartDto> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SparePartDto findById(String id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Override
    public SparePartDto save(SparePartDto dto) {
        SparePart entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
