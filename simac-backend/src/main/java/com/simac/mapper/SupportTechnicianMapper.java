package com.simac.mapper;

import com.simac.dto.SupportTechnicianDto;
import com.simac.entity.SupportTechnician;

public class SupportTechnicianMapper {

    public static SupportTechnicianDto toDto(SupportTechnician entity) {
        SupportTechnicianDto dto = new SupportTechnicianDto();
        dto.setId_support(entity.getId_support());
        dto.setName_support(entity.getName_support());
        dto.setContact_number(entity.getContact_number());
        return dto;
    }

    public static SupportTechnician toEntity(SupportTechnicianDto dto) {
        SupportTechnician entity = new SupportTechnician();
        entity.setId_support(dto.getId_support());
        entity.setName_support(dto.getName_support());
        entity.setContact_number(dto.getContact_number());
        return entity;
    }
}
