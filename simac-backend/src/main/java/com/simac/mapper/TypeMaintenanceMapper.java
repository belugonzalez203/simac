package com.simac.mapper;

import com.simac.dto.TypeMaintenanceDto;
import com.simac.entity.TypeMaintenance;

public class TypeMaintenanceMapper {

    public static TypeMaintenanceDto toDto(TypeMaintenance entity) {
        TypeMaintenanceDto dto = new TypeMaintenanceDto();
        dto.setId_type_maintenance(entity.getId_type_maintenance());
        dto.setName_type_maintenance(entity.getName_type_maintenance());
        return dto;
    }

    public static TypeMaintenance toEntity(TypeMaintenanceDto dto) {
        TypeMaintenance entity = new TypeMaintenance();
        entity.setId_type_maintenance(dto.getId_type_maintenance());
        entity.setName_type_maintenance(dto.getName_type_maintenance());
        return entity;
    }
}
