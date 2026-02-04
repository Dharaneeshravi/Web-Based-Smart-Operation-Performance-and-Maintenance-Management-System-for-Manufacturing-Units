package com.opmms.system.SmartOps.Maintenance.System.service.machine;

import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiRequestMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiResponseMachine;

public interface MachineService {
    ApiResponseMachine getAllMachine();

    ApiResponseMachine createMachine(ApiRequestMachine apiRequestMachine);

    ApiResponseMachine getMachineById(Long machineId);

    ApiResponseMachine updateMachineById(Long machineId, ApiRequestMachine apiRequestMachine);

    ApiResponseMachine deleteMachine(Long machineId);
}
