package com.opmms.system.SmartOps.Maintenance.System.service.machine;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Machine;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiRequestMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.ApiResponseMachine;
import com.opmms.system.SmartOps.Maintenance.System.payload.machine.MachineData;
import com.opmms.system.SmartOps.Maintenance.System.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineServiceImpl implements MachineService {

    private final MachineRepository machineRepository;
    private final ModelMapper mapper;

    @Override
    public ApiResponseMachine getAllMachine() {

        List<Machine> machineList=machineRepository.findAll();
        return buildResponse(200,machineList,"machine fetched successfully");
    }

    @Override
    public ApiResponseMachine createMachine(ApiRequestMachine apiRequestMachine) {

        Machine machine=machineRepository.save(mapToMachine(apiRequestMachine));
        return buildResponse(201,Collections.singletonList(machine),"machine created successfully");
    }

    @Override
    public ApiResponseMachine getMachineById(Long machineId) {

        Machine machine=findByIdOrThrow(machineId);
        return buildResponse(200,Collections.singletonList(machine),"machine fetched successfully");
    }

    @Override
    public ApiResponseMachine updateMachineById(Long machineId, ApiRequestMachine apiRequestMachine) {

        Machine machine=findByIdOrThrow(machineId);
        machine.setMachineName(apiRequestMachine.getMachineName());
        machine.setLocation(apiRequestMachine.getLocation());
        machine.setModel(apiRequestMachine.getModel());
        machine.setRemarks(apiRequestMachine.getRemarks());
        machine.setInstallationDate(apiRequestMachine.getInstallationDate());
        machine.setCapacity(apiRequestMachine.getCapacity());
        machine.setStatus(apiRequestMachine.getStatus());
        machine.setMachineType(apiRequestMachine.getMachineType());
        machine.setManufacturerName(apiRequestMachine.getManufacturerName());
        machine.setMachineCode(apiRequestMachine.getMachineCode());
        Machine updatedMachine=machineRepository.save(machine);
        return buildResponse(200,Collections.singletonList(updatedMachine),"machine updated successfully");
    }

    @Override
    public ApiResponseMachine deleteMachine(Long machineId) {

        Machine machine=findByIdOrThrow(machineId);
        machineRepository.delete(machine);
        return buildResponse(200,Collections.singletonList(machine),"machine deleted successfully");
    }

    private ApiResponseMachine buildResponse(int status, List<Machine> machineList, String message)
    {
        return new ApiResponseMachine(status,new MachineData(machineList==null? Collections.emptyList():machineList),message);
    }

    private Machine mapToMachine(ApiRequestMachine apiRequestMachine)
    {
        return mapper.map(apiRequestMachine, Machine.class);
    }

    private Machine findByIdOrThrow(Long machineId)
    {
        return machineRepository.findById(machineId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.MACHINE,"machine not found"));
    }
}
