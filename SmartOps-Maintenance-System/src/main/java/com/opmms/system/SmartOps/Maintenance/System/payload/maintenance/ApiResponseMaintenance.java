package com.opmms.system.SmartOps.Maintenance.System.payload.maintenance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseMaintenance {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private MaintenanceData maintenanceData;
    @JsonProperty("message")
    private String message;
}
