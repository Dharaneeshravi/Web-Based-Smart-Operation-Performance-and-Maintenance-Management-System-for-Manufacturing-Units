package com.opmms.system.SmartOps.Maintenance.System.service.machineassignment;

import com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment.ApiResponseMachineAssignment;

public interface MachineAssignmentService {
    ApiResponseMachineAssignment getAllMachineAssignment();

    ApiResponseMachineAssignment createMachineAssignment(Long machineId, Long userId);

    ApiResponseMachineAssignment getMachineAssignment(Long machineAssignmentId);
}
