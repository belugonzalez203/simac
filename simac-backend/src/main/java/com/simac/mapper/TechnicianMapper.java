package com.simac.mapper;

import com.simac.dto.TechnicianDto;
import com.simac.entity.Area;
import com.simac.entity.Technician;
import com.simac.entity.User;

public class TechnicianMapper {

    public static TechnicianDto toDto(Technician technician) {
        TechnicianDto dto = new TechnicianDto();
        dto.setId_tech(technician.getId_tech());
        dto.setName_tech(technician.getName_tech());
        dto.setContact_number(technician.getContact_number());
        dto.setId_area(technician.getArea().getId());
        dto.setId_user(technician.getUser().getId_user());
        return dto;
    }

    public static Technician toEntity(TechnicianDto dto, Area area, User user) {
        Technician technician = new Technician();
        technician.setId_tech(dto.getId_tech());
        technician.setName_tech(dto.getName_tech());
        technician.setContact_number(dto.getContact_number());
        technician.setArea(area);
        technician.setUser(user);
        return technician;
    }
}
