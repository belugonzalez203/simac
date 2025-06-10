package com.simac.mapper;

import com.simac.dto.WorkOrderDto;
import com.simac.entity.*;
import org.springframework.stereotype.Component;

@Component
public class WorkOrderMapper {

    public WorkOrderDto toDto(WorkOrder workOrder) {
        return WorkOrderDto.builder()
                .id_order(workOrder.getId_order())
                .userId(workOrder.getUser().getIdUser())
                .technicianId(workOrder.getTechnician().getIdTech())
                .date_request(workOrder.getDate_request())
                .hour_request(workOrder.getHour_request())
                .date_delivery(workOrder.getDate_delivery())
                .equipmentId(workOrder.getEquipment().getId_equipment())
                .typeMaintenanceId(workOrder.getType_maintenance().getId_type_maintenance())
                .classMaintenanceId(workOrder.getClass_maintenance().getId_class_maintenance())
                .priority(workOrder.getPriority())
                .work_requested(workOrder.getWork_requested())
                .start_date(workOrder.getStart_date())
                .start_hour(workOrder.getStart_hour())
                .completion_date(workOrder.getCompletion_date())
                .completion_hour(workOrder.getCompletion_hour())
                .failure_cause(workOrder.getFailure_cause())
                .failure_analysis(workOrder.getFailure_analysis())
                .work_performed_details(workOrder.getWork_performed_details())
                .observations(workOrder.getObservations())
                .build();
    }

    public WorkOrder toEntity(WorkOrderDto dto, User user, Technician technician, Equipment equipment,
                              TypeMaintenance type, ClassMaintenance clazz) {
        return WorkOrder.builder()
                .id_order(dto.getId_order())
                .user(user)
                .technician(technician)
                .date_request(dto.getDate_request())
                .hour_request(dto.getHour_request())
                .date_delivery(dto.getDate_delivery())
                .equipment(equipment)
                .type_maintenance(type)
                .class_maintenance(clazz)
                .priority(dto.getPriority())
                .work_requested(dto.getWork_requested())
                .start_date(dto.getStart_date())
                .start_hour(dto.getStart_hour())
                .completion_date(dto.getCompletion_date())
                .completion_hour(dto.getCompletion_hour())
                .failure_cause(dto.getFailure_cause())
                .failure_analysis(dto.getFailure_analysis())
                .work_performed_details(dto.getWork_performed_details())
                .observations(dto.getObservations())
                .build();
    }
}
