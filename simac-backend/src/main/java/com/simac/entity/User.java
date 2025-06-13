package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name = "id_user", length = 10, nullable = false)
    private String idUser;

    @Column(name = "name_user", length = 50, nullable = false)
    private String nameUser;

    @Column(name = "type_user", length = 30, nullable = false)
    private String typeUser;
}
