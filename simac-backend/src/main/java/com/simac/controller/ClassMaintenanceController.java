package com.simac.controller;

import com.simac.dto.ClassMaintenanceDto;
import com.simac.service.ClassMaintenanceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/class-maintenance")
public class ClassMaintenanceController {

    private final ClassMaintenanceService service;

    public ClassMaintenanceController(ClassMaintenanceService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClassMaintenanceDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ClassMaintenanceDto getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ClassMaintenanceDto create(@RequestBody ClassMaintenanceDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public ClassMaintenanceDto update(@PathVariable String id, @RequestBody ClassMaintenanceDto dto) {
        dto.setId_class_maintenance(id); // Asegurarse de usar el ID de la ruta
        return service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
