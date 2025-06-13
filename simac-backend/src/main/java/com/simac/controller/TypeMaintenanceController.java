package com.simac.controller;

import com.simac.dto.TypeMaintenanceDto;
import com.simac.service.TypeMaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type-maintenance")
public class TypeMaintenanceController {

    private final TypeMaintenanceService service;

    public TypeMaintenanceController(TypeMaintenanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<TypeMaintenanceDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public TypeMaintenanceDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public TypeMaintenanceDto create(@RequestBody TypeMaintenanceDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public TypeMaintenanceDto update(@PathVariable String id, @RequestBody TypeMaintenanceDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

