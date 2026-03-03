package com.opmms.system.SmartOps.Maintenance.System.payload.shift;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseShift {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private ShiftData shiftData;
    @JsonProperty("message")
    private String message;
}
