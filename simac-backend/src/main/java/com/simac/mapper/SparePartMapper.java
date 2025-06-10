package com.simac.mapper;

import com.simac.dto.SparePartDto;
import com.simac.entity.SparePart;
import org.springframework.stereotype.Component;

@Component
public class SparePartMapper {

    public SparePartDto toDto(SparePart entity) {
        SparePartDto dto = new SparePartDto();
        dto.setId_spare_part(entity.getId_spare_part());
        dto.setName_spare_part(entity.getName_spare_part());
        dto.setStock_spare_part(entity.getStock_spare_part());
        return dto;
    }

    public SparePart toEntity(SparePartDto dto) {
        SparePart entity = new SparePart();
        entity.setId_spare_part(dto.getId_spare_part());
        entity.setName_spare_part(dto.getName_spare_part());
        entity.setStock_spare_part(dto.getStock_spare_part());
        return entity;
    }
}
