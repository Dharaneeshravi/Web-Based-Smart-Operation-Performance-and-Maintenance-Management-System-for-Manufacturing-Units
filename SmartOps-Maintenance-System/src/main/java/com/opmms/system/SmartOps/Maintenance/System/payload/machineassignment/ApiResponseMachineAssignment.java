package com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseMachineAssignment {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("data")
    private MachineAssignmentData machineAssignmentData;
    @JsonProperty("message")
    private String message;
}
