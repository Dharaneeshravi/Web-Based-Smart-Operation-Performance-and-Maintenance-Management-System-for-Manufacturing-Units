package com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationMachineAssignment {

    private Long MachineAssignmentId;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private Long userId;
    private Long machineId;
}
