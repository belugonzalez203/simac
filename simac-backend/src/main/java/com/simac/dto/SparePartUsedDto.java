package com.simac.dto;

import lombok.Data;

@Data
public class SparePartUsedDto {
    private Long id;
    private String id_spare_part;
    private int quantity_used;
}
