package com.simac.controller;

import com.simac.dto.SparePartUsedDto;
import com.simac.service.SparePartUsedService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spare-parts-used")
public class SparePartUsedController {

    private final SparePartUsedService service;

    public SparePartUsedController(SparePartUsedService service) {
        this.service = service;
    }

    @GetMapping
    public List<SparePartUsedDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public SparePartUsedDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public SparePartUsedDto create(@RequestBody SparePartUsedDto dto) {
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public SparePartUsedDto update(@PathVariable Long id, @RequestBody SparePartUsedDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
