package com.simac.service;

import com.simac.dto.AreaDto;
import com.simac.entity.Area;
import com.simac.mapper.AreaMapper;
import com.simac.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;
    private final AreaMapper areaMapper;

    public AreaServiceImpl(AreaRepository areaRepository, AreaMapper areaMapper) {
        this.areaRepository = areaRepository;
        this.areaMapper = areaMapper;
    }

    @Override
    public List<AreaDto> findAll() {
        return areaRepository.findAll()
                .stream()
                .map(areaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AreaDto> findById(String id) {
        return areaRepository.findById(id)
                .map(areaMapper::toDto);
    }

    @Override
    public AreaDto save(AreaDto dto) {
        Area area = areaMapper.toEntity(dto);
        return areaMapper.toDto(areaRepository.save(area));
    }

    @Override
    public AreaDto update(AreaDto dto) {
        Area area = areaMapper.toEntity(dto);
        return areaMapper.toDto(areaRepository.save(area));
    }

    @Override
    public void delete(String id) {
        areaRepository.deleteById(id);
    }
}
