package com.simac.controller;

import com.simac.dto.AreaDto;
import com.simac.entity.Area;
import com.simac.mapper.AreaMapper;
import com.simac.service.AreaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/areas")
public class AreaController {

    private final AreaService areaService;
    private final AreaMapper areaMapper;

    public AreaController(AreaService areaService, AreaMapper areaMapper) {
        this.areaService = areaService;
        this.areaMapper = areaMapper;
    }

    @GetMapping
    public List<AreaDto> getAllAreas() {
        return areaService.findAll().stream()
                .map(areaMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public AreaDto getAreaById(@PathVariable String id) {
        return areaService.findById(id)
                .orElseThrow(() -> new RuntimeException("Area not found with id: " + id));
    }

    @PostMapping
    public AreaDto createArea(@RequestBody AreaDto dto) {
        Area created = areaService.save(areaMapper.toEntity(dto));
        return areaMapper.toDto(created);
    }

    @PutMapping("/{id}")
    public AreaDto updateArea(@PathVariable String id, @RequestBody AreaDto dto) {
        Area updated = areaMapper.toEntity(dto);
        updated.setId(id);
        return areaMapper.toDto(areaService.update(updated));
    }

    @DeleteMapping("/{id}")
    public void deleteArea(@PathVariable String id) {
        areaService.delete(id);
    }
}
