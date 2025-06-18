package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SparePartUsed")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SparePartUsed {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private WorkOrder work_order;

    @ManyToOne
    @JoinColumn(name = "id_spare_part")
    private SparePart spare_part;

    @Column(name = "quantity_used")
    private Integer quantity_used;
}
