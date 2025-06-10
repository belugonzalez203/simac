package com.simac.controller;

import com.simac.dto.SparePartDto;
import com.simac.service.SparePartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spare-parts")
public class SparePartController {

    private final SparePartService service;

    public SparePartController(SparePartService service) {
        this.service = service;
    }

    @GetMapping
    public List<SparePartDto> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SparePartDto getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public SparePartDto create(@RequestBody SparePartDto dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public SparePartDto update(@PathVariable String id, @RequestBody SparePartDto dto) {
        dto.setId_spare_part(id);
        return service.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}

