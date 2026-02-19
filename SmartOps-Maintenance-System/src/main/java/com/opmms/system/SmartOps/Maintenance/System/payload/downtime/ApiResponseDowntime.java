package com.opmms.system.SmartOps.Maintenance.System.payload.downtime;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDowntime {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private DowntimeData downtimeData;
    @JsonProperty("message")
    private String message;
}
