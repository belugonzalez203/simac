package com.simac.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Area")
@Data
public class Area {

    @Id
    @Column(name = "id", nullable = false, length = 6)
    private String id;

    @Column(name = "area", nullable = false, length = 30)
    private String area;

    @Column(name = "in_charge", length = 30)
    private String inCharge;

    @Column(name = "contact", length = 8)
    private String contact;
}

