package com.simac.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private String idUser;
    private String nameUser;
    private String typeUser;
}
