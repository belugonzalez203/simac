package com.simac.mapper;

import com.simac.dto.UserDto;
import com.simac.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toDto(User user) {
        if (user == null) return null;
        return UserDto.builder()
                .idUser(user.getIdUser())
                .nameUser(user.getNameUser())
                .typeUser(user.getTypeUser())
                .build();
    }

    public User toEntity(UserDto dto) {
        if (dto == null) return null;
        return User.builder()
                .idUser(dto.getIdUser())
                .nameUser(dto.getNameUser())
                .typeUser(dto.getTypeUser())
                .build();
    }

    public void updateEntityFromDto(UserDto dto, User entity) {
        if (dto == null || entity == null) return;
        entity.setNameUser(dto.getNameUser());
        entity.setTypeUser(dto.getTypeUser());
        // No actualizamos el idUser para mantener consistencia
    }
}
