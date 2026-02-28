package com.opmms.system.SmartOps.Maintenance.System.payload.maintenance;

import com.opmms.system.SmartOps.Maintenance.System.model.MaintenanceType;
import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestMaintenance {

    private MaintenanceType maintenanceType;
    private Date scheduledDate;
    private Date performedDate;
    private String description;
    private Status status;
    private Double cost;
}
