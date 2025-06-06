package com.simac.service;

import com.simac.entity.Area;
import com.simac.repository.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService {

    private final AreaRepository areaRepository;

    public AreaServiceImpl(AreaRepository areaRepository) {
        this.areaRepository = areaRepository;
    }

    @Override
    public List<Area> findAll() {
        return areaRepository.findAll();
    }

    @Override
    public Optional<Area> findById(String id) {
        return areaRepository.findById(id);
    }

    @Override
    public Area save(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public void deleteById(String id) {
        areaRepository.deleteById(id);
    }
}
continuamos