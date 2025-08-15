package com.simac.controller;

import com.simac.entity.SparePart;
import com.simac.service.SparePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/spareParts")
@CrossOrigin(origins = "*")
public class SparePartController {

    private final SparePartService sparePartService;

    public SparePartController(SparePartService sparePartService) {
        this.sparePartService = sparePartService;
    }

    @GetMapping
    public List<SparePart> getAll() {
        return sparePartService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SparePart> getById(@PathVariable String id) {
        return sparePartService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<SparePart> create(@RequestBody SparePart sparePart) {
        return ResponseEntity.ok(sparePartService.save(sparePart));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SparePart> update(@PathVariable String id, @RequestBody SparePart updated) {
        return sparePartService.findById(id)
                .map(existing -> {
                    existing.setNombre_sparePartupdated.getNombre_sparePart());
                    existing.setExistencia_sparePart(updated.getExistencia_sparePart());
                    return ResponseEntity.ok(sparePartService.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (sparePartService.findById(id).isPresent()) {
            sparePartService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
