package com.simac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipment")
@Getter
@Setter
@NoArgsConstructor
public class Equipment {

    @Id
    @Column(name = "id_equipment", nullable = false, length = 10)
    private String id_equipment;

    @Column(name = "name_equipment", nullable = false, length = 25)
    private String name_equipment;

    @Column(name = "number_plate", nullable = false, length = 10)
    private String number_plate;

    @Column(name = "brand_equipment", length = 25)
    private String brand_equipment;

    @Column(name = "model_equipment", length = 25)
    private String model_equipment;

    @Column(name = "chassis_equipment", nullable = false, length = 25)
    private String chassis_equipment;

    @Enumerated(EnumType.STRING)
    @Column(name = "service_equipment", nullable = false)
    private ServiceStatus service_equipment;
}
