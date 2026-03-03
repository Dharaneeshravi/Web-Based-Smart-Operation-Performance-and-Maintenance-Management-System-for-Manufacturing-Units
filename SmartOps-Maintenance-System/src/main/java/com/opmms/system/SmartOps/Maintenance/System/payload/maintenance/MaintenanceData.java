package com.opmms.system.SmartOps.Maintenance.System.payload.maintenance;

import com.opmms.system.SmartOps.Maintenance.System.model.Maintenance;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaintenanceData {

    private List<InformationMaintenance> informationMaintenances;
}
