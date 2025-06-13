package com.simac.controller;

import com.simac.dto.SupportTechnicianDto;
import com.simac.service.SupportTechnicianService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/support-technicians")
public class SupportTechnicianController {

    private final SupportTechnicianService service;

    public SupportTechnicianController(SupportTechnicianService service) {
        this.service = service;
    }

    @GetMapping
    public List<SupportTechnicianDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SupportTechnicianDto getById(@PathVariable String id) {
        return service.getById(id);
    }

    @PostMapping
    public SupportTechnicianDto create(@RequestBody SupportTechnicianDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public SupportTechnicianDto update(@PathVariable String id, @RequestBody SupportTechnicianDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
