package com.simac.mapper;

import com.simac.dto.EquipmentDto;
import com.simac.entity.Equipment;
import com.simac.entity.ServiceStatus;
import org.springframework.stereotype.Component;

@Component
public class EquipmentMapper {

    public EquipmentDto toDto(Equipment entity) {
        EquipmentDto dto = new EquipmentDto();
        dto.setId_equipment(entity.getId_equipment());
        dto.setName_equipment(entity.getName_equipment());
        dto.setNumber_plate(entity.getNumber_plate());
        dto.setBrand_equipment(entity.getBrand_equipment());
        dto.setModel_equipment(entity.getModel_equipment());
        dto.setChassis_equipment(entity.getChassis_equipment());
        dto.setService_equipment(entity.getService_equipment().name());
        return dto;
    }

    public Equipment toEntity(EquipmentDto dto) {
        Equipment entity = new Equipment();
        entity.setId_equipment(dto.getId_equipment());
        entity.setName_equipment(dto.getName_equipment());
        entity.setNumber_plate(dto.getNumber_plate());
        entity.setBrand_equipment(dto.getBrand_equipment());
        entity.setModel_equipment(dto.getModel_equipment());
        entity.setChassis_equipment(dto.getChassis_equipment());
        entity.setService_equipment(ServiceStatus.valueOf(dto.getService_equipment()));
        return entity;
    }
}
