package com.simac.service.impl;

import com.simac.dto.TechnicianDto;
import com.simac.entity.Area;
import com.simac.entity.Technician;
import com.simac.entity.User;
import com.simac.mapper.TechnicianMapper;
import com.simac.repository.AreaRepository;
import com.simac.repository.TechnicianRepository;
import com.simac.repository.UserRepository;
import com.simac.service.TechnicianService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TechnicianServiceImpl implements TechnicianService {

    private final TechnicianRepository technicianRepository;
    private final AreaRepository areaRepository;
    private final UserRepository userRepository;

    public TechnicianServiceImpl(TechnicianRepository technicianRepository,
                                 AreaRepository areaRepository,
                                 UserRepository userRepository) {
        this.technicianRepository = technicianRepository;
        this.areaRepository = areaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<TechnicianDto> getAll() {
        return technicianRepository.findAll().stream()
                .map(TechnicianMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TechnicianDto getById(String id) {
        Technician technician = technicianRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Technician not found"));
        return TechnicianMapper.toDto(technician);
    }

    @Override
    public TechnicianDto create(TechnicianDto dto) {
        Area area = areaRepository.findById(dto.getId_area())
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));
        User user = userRepository.findById(dto.getId_user())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Technician technician = TechnicianMapper.toEntity(dto, area, user);
        technicianRepository.save(technician);
        return TechnicianMapper.toDto(technician);
    }

    @Override
    public TechnicianDto update(String id, TechnicianDto dto) {
        Technician existing = technicianRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Technician not found"));

        Area area = areaRepository.findById(dto.getId_area())
                .orElseThrow(() -> new EntityNotFoundException("Area not found"));
        User user = userRepository.findById(dto.getId_user())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        existing.setName_tech(dto.getName_tech());
        existing.setContact_number(dto.getContact_number());
        existing.setArea(area);
        existing.setUser(user);

        technicianRepository.save(existing);
        return TechnicianMapper.toDto(existing);
    }

    @Override
    public void delete(String id) {
        technicianRepository.deleteById(id);
    }
}
