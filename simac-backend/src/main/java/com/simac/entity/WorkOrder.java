package com.simac.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "WorkOrder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkOrder {

    @Id
    @Column(name = "id_order", nullable = false, length = 10)
    private String id_order;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_tech", referencedColumnName = "id_tech")
    private Technician technician;

    @Column(name = "date_request")
    private LocalDate date_request;

    @Column(name = "hour_request")
    private LocalTime hour_request;

    @Column(name = "date_delivery")
    private LocalDate date_delivery;

    @ManyToOne
    @JoinColumn(name = "id_equipment", referencedColumnName = "id_equipment")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "type_maintenance", referencedColumnName = "id_type_maintenance")
    private TypeMaintenance type_maintenance;

    @ManyToOne
    @JoinColumn(name = "class_maintenance", referencedColumnName = "id_class_maintenance")
    private ClassMaintenance class_maintenance;

    @Column(name = "priority")
    private String priority;

    @Column(name = "work_requested", columnDefinition = "TEXT")
    private String work_requested;

    @Column(name = "start_date")
    private LocalDate start_date;

    @Column(name = "start_hour")
    private LocalTime start_hour;

    @Column(name = "completion_date")
    private LocalDate completion_date;

    @Column(name = "completion_hour")
    private LocalTime completion_hour;

    @Column(name = "failure_cause", columnDefinition = "TEXT")
    private String failure_cause;

    @Column(name = "failure_analysis", columnDefinition = "TEXT")
    private String failure_analysis;

    @Column(name = "work_performed_details", columnDefinition = "TEXT")
    private String work_performed_details;

    @Column(name = "observations", columnDefinition = "TEXT")
    private String observations;

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL)
    private List<SupportTechnician> support_technicians;

    @OneToMany(mappedBy = "workOrder", cascade = CascadeType.ALL)
    private List<SparePartUsed> spare_parts_used;
}
