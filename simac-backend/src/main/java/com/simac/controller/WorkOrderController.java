
package com.simac.controller;

import com.simac.dto.WorkOrderDto;
import com.simac.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workorders")
@CrossOrigin(origins = "*")
public class WorkOrderController {

    @Autowired
    private WorkOrderService workOrderService;

    @PostMapping
    public WorkOrderDto create(@RequestBody WorkOrderDto dto) {
        return workOrderService.save(dto);
    }

    @GetMapping
    public List<WorkOrderDto> getAll() {
        return workOrderService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<WorkOrderDto> getById(@PathVariable String id) {
        return workOrderService.findById(id);
    }

    @PutMapping("/{id}")
    public WorkOrderDto update(@PathVariable String id, @RequestBody WorkOrderDto dto) {
        dto.setId_order(id);
        return workOrderService.save(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        workOrderService.deleteById(id);
    }
}
