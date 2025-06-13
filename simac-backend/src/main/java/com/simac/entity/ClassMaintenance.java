package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ClassMaintenance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassMaintenance {

    @Id
    @Column(name = "id_class", length = 2, nullable = false)
    private String id_class;

    @Column(name = "class_name", length = 50, nullable = false, unique = true)
    private String class_name;
}
