package com.simac.service;

import com.simac.dto.SparePartUsedDto;
import com.simac.entity.SparePart;
import com.simac.entity.SparePartUsed;
import com.simac.mapper.SparePartUsedMapper;
import com.simac.repository.SparePartRepository;
import com.simac.repository.SparePartUsedRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SparePartUsedServiceImpl implements SparePartUsedService {

    private final SparePartUsedRepository usedRepository;
    private final SparePartRepository sparePartRepository;

    public SparePartUsedServiceImpl(SparePartUsedRepository usedRepository, SparePartRepository sparePartRepository) {
        this.usedRepository = usedRepository;
        this.sparePartRepository = sparePartRepository;
    }

    @Override
    public List<SparePartUsedDto> getAll() {
        return usedRepository.findAll().stream()
                .map(SparePartUsedMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SparePartUsedDto getById(Long id) {
        return usedRepository.findById(id)
                .map(SparePartUsedMapper::toDto)
                .orElse(null);
    }

    @Override
    public SparePartUsedDto create(SparePartUsedDto dto) {
        SparePartUsed entity = SparePartUsedMapper.toEntity(dto);
        SparePart sparePart = sparePartRepository.findById(dto.getId_spare_part()).orElse(null);
        entity.setSparePart(sparePart);
        return SparePartUsedMapper.toDto(usedRepository.save(entity));
    }

    @Override
    public SparePartUsedDto update(Long id, SparePartUsedDto dto) {
        if (!usedRepository.existsById(id)) return null;
        SparePartUsed entity = SparePartUsedMapper.toEntity(dto);
        entity.setId(id);
        SparePart sparePart = sparePartRepository.findById(dto.getId_spare_part()).orElse(null);
        entity.setSparePart(sparePart);
        return SparePartUsedMapper.toDto(usedRepository.save(entity));
    }

    @Override
    public void delete(Long id) {
        usedRepository.deleteById(id);
    }
}
