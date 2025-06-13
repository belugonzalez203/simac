package com.simac.service;

import com.simac.dto.WorkOrderDto;
import com.simac.entity.*;
import com.simac.mapper.WorkOrderMapper;
import com.simac.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    @Autowired
    private WorkOrderRepository workOrderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TechnicianRepository technicianRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private TypeMaintenanceRepository typeMaintenanceRepository;
    @Autowired
    private ClassMaintenanceRepository classMaintenanceRepository;
    @Autowired
    private WorkOrderMapper mapper;

    @Override
    public WorkOrderDto save(WorkOrderDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Technician tech = technicianRepository.findById(dto.getTechnicianId()).orElseThrow();
        Equipment eq = equipmentRepository.findById(dto.getEquipmentId()).orElseThrow();
        TypeMaintenance type = typeMaintenanceRepository.findById(dto.getTypeMaintenanceId()).orElseThrow();
        ClassMaintenance clazz = classMaintenanceRepository.findById(dto.getClassMaintenanceId()).orElseThrow();

        WorkOrder entity = mapper.toEntity(dto, user, tech, eq, type, clazz);
        return mapper.toDto(workOrderRepository.save(entity));
    }

    @Override
    public Optional<WorkOrderDto> findById(String id) {
        return workOrderRepository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public List<WorkOrderDto> findAll() {
        return workOrderRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(String id) {
        workOrderRepository.deleteById(id);
    }
}
