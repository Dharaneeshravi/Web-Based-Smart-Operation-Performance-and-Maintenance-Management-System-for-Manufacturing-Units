package com.opmms.system.SmartOps.Maintenance.System.payload.machine;

import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationMachine {

    private Long machineId;
    private String machineName;
    private String location;
    private String model;
    private LocalDate installationDate;
    private String machineType;
    private String capacity;
    private Status status;
    private String remarks;
    private String machineCode;
    private String manufacturerName;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}
