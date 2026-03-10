package com.opmms.system.SmartOps.Maintenance.System.service.machineassignment;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Machine;
import com.opmms.system.SmartOps.Maintenance.System.model.MachineAssignment;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.model.User;
import com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment.ApiResponseMachineAssignment;
import com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment.InformationMachineAssignment;
import com.opmms.system.SmartOps.Maintenance.System.payload.machineassignment.MachineAssignmentData;
import com.opmms.system.SmartOps.Maintenance.System.repository.MachineAssignmentRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.MachineRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MachineAssignmentServiceImpl implements MachineAssignmentService {

    private final MachineAssignmentRepository machineAssignmentRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponseMachineAssignment getAllMachineAssignment() {

        List<InformationMachineAssignment> informationMachineAssignments = machineAssignmentRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return buildResponse(200,informationMachineAssignments,"machine assignment data fetched successfully");
    }

    @Override
    public ApiResponseMachineAssignment createMachineAssignment(Long machineId, Long userId)
    {
        Machine machine=machineRepository.findById(machineId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.MACHINE,"machine not found"));

        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.USER,"User not found "));

        MachineAssignment machineAssignment=new MachineAssignment();
        machineAssignment.setMachineId(machineId);
        machineAssignment.setUserId(userId);
        machineAssignment.setMachine(machine);
        machineAssignment.setUser(user);
        MachineAssignment savedMachineAssignment=machineAssignmentRepository.save(machineAssignment);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedMachineAssignment)),"machine assignment created successfully");
    }

    @Override
    public ApiResponseMachineAssignment getMachineAssignment(Long machineAssignmentId) {

        MachineAssignment machineAssignment=findByIdOrThrow(machineAssignmentId);
        return buildResponse(200,Collections.singletonList(mapToInfo(machineAssignment)),"machine assignment found successfully");
    }


    private ApiResponseMachineAssignment buildResponse(int status, List<InformationMachineAssignment> data,String message)
    {
        return new ApiResponseMachineAssignment(status,new MachineAssignmentData(data==null?Collections.emptyList():data),message);
    }

    private MachineAssignment findByIdOrThrow(Long machineAssignmentId)
    {
        return machineAssignmentRepository.findById(machineAssignmentId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.MACHINE_ASSIGNMENT,"machine assignment not found"));
    }

    private InformationMachineAssignment mapToInfo(MachineAssignment machineAssignment)
    {
        return modelMapper.map(machineAssignment, InformationMachineAssignment.class);
    }
}
