package com.opmms.system.SmartOps.Maintenance.System.payload.performance;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponsePerformance {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private PerformanceData performanceData;
    @JsonProperty("message")
    private String message;
}
