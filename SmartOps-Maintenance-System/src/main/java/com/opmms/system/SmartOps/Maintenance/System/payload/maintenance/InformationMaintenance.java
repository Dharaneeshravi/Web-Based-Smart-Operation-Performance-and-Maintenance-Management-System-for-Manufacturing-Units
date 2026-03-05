package com.opmms.system.SmartOps.Maintenance.System.payload.maintenance;

import com.opmms.system.SmartOps.Maintenance.System.model.MaintenanceType;
import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationMaintenance {

    private Long maintenanceId;
    private MaintenanceType maintenanceType;
    private LocalDate scheduledDate;
    private LocalDate performedDate;
    private String description;
    private Status status;
    private Double cost;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long machineId;
    private Long userId;
}
