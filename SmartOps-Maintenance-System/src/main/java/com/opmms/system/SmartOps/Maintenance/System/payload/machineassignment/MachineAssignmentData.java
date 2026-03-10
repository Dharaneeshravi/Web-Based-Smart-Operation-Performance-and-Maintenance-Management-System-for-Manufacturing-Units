package com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineAssignmentData {

    private List<InformationMachineAssignment> informationMachineAssignments;
}
