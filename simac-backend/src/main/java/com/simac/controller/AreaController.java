package com.simac.controller;

import com.simac.entity.Area;
import com.simac.service.AreaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
@CrossOrigin(origins = "*") // Permite peticiones desde el frontend local u otras fuentes
public class AreaController {

    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping
    public List<Area> getAllAreas() {
        return areaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Area> getAreaById(@PathVariable String id) {
        return areaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Area> createArea(@RequestBody Area area) {
        Area saved = areaService.save(area);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable String id, @RequestBody Area updatedArea) {
        return areaService.findById(id)
                .map(existing -> {
                    existing.setArea(updatedArea.getArea());
                    existing.setResponsable(updatedArea.getResponsable());
                    existing.setContacto(updatedArea.getContacto());
                    return ResponseEntity.ok(areaService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArea(@PathVariable String id) {
        if (areaService.findById(id).isPresent()) {
            areaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
