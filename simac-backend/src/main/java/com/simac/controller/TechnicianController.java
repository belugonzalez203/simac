package com.simac.controller;

import com.simac.dto.TechnicianDto;
import com.simac.service.TechnicianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technicians")
public class TechnicianController {

    private final TechnicianService technicianService;

    public TechnicianController(TechnicianService technicianService) {
        this.technicianService = technicianService;
    }

    @GetMapping
    public List<TechnicianDto> getAll() {
        return technicianService.getAll();
    }

    @GetMapping("/{id}")
    public TechnicianDto getById(@PathVariable String id) {
        return technicianService.getById(id);
    }

    @PostMapping
    public TechnicianDto create(@RequestBody TechnicianDto dto) {
        return technicianService.create(dto);
    }

    @PutMapping("/{id}")
    public TechnicianDto update(@PathVariable String id, @RequestBody TechnicianDto dto) {
        return technicianService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        technicianService.delete(id);
    }
}
