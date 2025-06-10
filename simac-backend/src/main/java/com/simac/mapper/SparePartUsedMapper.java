package com.simac.mapper;

import com.simac.dto.SparePartUsedDto;
import com.simac.entity.SparePartUsed;

public class SparePartUsedMapper {

    public static SparePartUsedDto toDto(SparePartUsed entity) {
        SparePartUsedDto dto = new SparePartUsedDto();
        dto.setId(entity.getId());
        dto.setId_spare_part(entity.getSparePart().getId_spare_part());
        dto.setQuantity_used(entity.getQuantity_used());
        return dto;
    }

    public static SparePartUsed toEntity(SparePartUsedDto dto) {
        SparePartUsed entity = new SparePartUsed();
        entity.setId(dto.getId());
        entity.setQuantity_used(dto.getQuantity_used());
        // El sparePart debe ser seteado manualmente en el Service si se carga por ID
        return entity;
    }
}
