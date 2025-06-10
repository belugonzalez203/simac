package com.simac.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrderDto {
    private String id_order;
    private String userId;
    private String technicianId;
    private LocalDate date_request;
    private LocalTime hour_request;
    private LocalDate date_delivery;
    private String equipmentId;
    private String typeMaintenanceId;
    private String classMaintenanceId;
    private String priority;
    private String work_requested;
    private LocalDate start_date;
    private LocalTime start_hour;
    private LocalDate completion_date;
    private LocalTime completion_hour;
    private String failure_cause;
    private String failure_analysis;
    private String work_performed_details;
    private String observations;
}
