package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "TypeMaintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeMaintenance {

    @Id
    @Column(name = "id_type", length = 2, nullable = false)
    private String id_type;

    @Column(name = "type_name", length = 50, nullable = false, unique = true)
    private String type_name;
}
