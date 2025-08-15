package com.simac.service;

import com.simac.entity.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    List<Area> findAll();
    Optional<Area> findById(String id);
    Area save(Area area);
    void deleteById(String id);
}
