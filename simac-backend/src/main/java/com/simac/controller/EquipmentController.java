package com.simac.controller;

import com.simac.dto.EquipmentDto;
import com.simac.entity.Equipment;
import com.simac.mapper.EquipmentMapper;
import com.simac.service.EquipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    private final EquipmentService service;
    private final EquipmentMapper mapper;

    public EquipmentController(EquipmentService service, EquipmentMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<EquipmentDto> getAll() {
        return service.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EquipmentDto getById(@PathVariable String id) {
        return mapper.toDto(service.findById(id));
    }

    @PostMapping
    public EquipmentDto create(@RequestBody EquipmentDto dto) {
        Equipment entity = mapper.toEntity(dto);
        return mapper.toDto(service.save(entity));
    }

    @PutMapping("/{id}")
    public EquipmentDto update(@PathVariable String id, @RequestBody EquipmentDto dto) {
        Equipment entity = mapper.toEntity(dto);
        entity.setId_equipment(id);
        return mapper.toDto(service.update(entity));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
