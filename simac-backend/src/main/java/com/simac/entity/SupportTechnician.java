package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "SupportTechnician")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTechnician {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private WorkOrder work_order;

    @ManyToOne
    @JoinColumn(name = "id_technician")
    private Technician technician;
}
