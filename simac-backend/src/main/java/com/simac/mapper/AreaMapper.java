package com.simac.mapper;

import com.simac.dto.AreaDto;
import com.simac.entity.Area;
import org.springframework.stereotype.Component;

@Component
public class AreaMapper {

    public AreaDto toDto(Area area) {
        AreaDto dto = new AreaDto();
        dto.setId(area.getId());
        dto.setArea(area.getArea());
        dto.setInCharge(area.getInCharge());
        dto.setContact(area.getContact());
        return dto;
    }

    public Area toEntity(AreaDto dto) {
        Area area = new Area();
        area.setId(dto.getId());
        area.setArea(dto.getArea());
        area.setInCharge(dto.getInCharge());
        area.setContact(dto.getContact());
        return area;
    }
}

