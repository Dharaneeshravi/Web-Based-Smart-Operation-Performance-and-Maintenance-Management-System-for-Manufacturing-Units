package com.opmms.system.SmartOps.Maintenance.System.service.maintenance;

import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiRequestMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiResponseMaintenance;

public interface MaintenanceService {
    ApiResponseMaintenance getAllMaintenance();

    ApiResponseMaintenance createMaintenance(ApiRequestMaintenance apiRequestMaintenance);

    ApiResponseMaintenance getMaintenanceById(Long maintenanceId);

    ApiResponseMaintenance updateMaintenanceById(Long maintenanceId, ApiRequestMaintenance apiRequestMaintenance);

    ApiResponseMaintenance deleteMaintenanceById(Long maintenanceId);
}
