package com.simac.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "SparePart")
@Getter
@Setter
@NoArgsConstructor
public class SparePart {

    @Id
    @Column(name = "id_spare_part", nullable = false, length = 10)
    private String id_spare_part;

    @Column(name = "name_spare_part", nullable = false, length = 50)
    private String name_spare_part;

    @Column(name = "stock_spare_part")
    private Integer stock_spare_part;
}
