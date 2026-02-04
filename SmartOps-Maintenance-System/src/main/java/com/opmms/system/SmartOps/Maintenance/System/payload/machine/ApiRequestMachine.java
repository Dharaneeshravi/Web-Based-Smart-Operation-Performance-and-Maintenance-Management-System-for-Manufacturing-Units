package com.opmms.system.SmartOps.Maintenance.System.payload.machine;

import com.opmms.system.SmartOps.Maintenance.System.model.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiRequestMachine {

    private String machineName;
    private String machineCode;
    private String location;
    private String manufacturer;
    private String model;
    private Date installationDate;
    private Integer ratedCapacity;
    private Status status;
    private String remarks;
}
