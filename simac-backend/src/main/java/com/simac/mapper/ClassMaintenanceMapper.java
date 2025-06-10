package com.simac.mapper;

import com.simac.dto.ClassMaintenanceDto;
import com.simac.entity.ClassMaintenance;
import org.springframework.stereotype.Component;

@Component
public class ClassMaintenanceMapper {

    public ClassMaintenanceDto toDto(ClassMaintenance entity) {
        ClassMaintenanceDto dto = new ClassMaintenanceDto();
        dto.setId_class_maintenance(entity.getId_class());
        dto.setName_class_maintenance(entity.getClass_name());
        return dto;
    }

    public ClassMaintenance toEntity(ClassMaintenanceDto dto) {
        ClassMaintenance entity = new ClassMaintenance();
        entity.setId_class(dto.getId_class_maintenance());
        entity.setClass_name(dto.getName_class_maintenance());
        return entity;
    }
}

