package com.opmms.system.SmartOps.Maintenance.System.service.downtime;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Downtime;
import com.opmms.system.SmartOps.Maintenance.System.model.Machine;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.model.User;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiRequestDowntime;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.ApiResponseDowntime;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.DowntimeData;
import com.opmms.system.SmartOps.Maintenance.System.payload.downtime.InformationDowntime;
import com.opmms.system.SmartOps.Maintenance.System.repository.DowntimeRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.MachineRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DowntimeServiceImpl implements DowntimeService {

    private final DowntimeRepository downtimeRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;

    @Override
    public ApiResponseDowntime getAllDowntime() {

        List<InformationDowntime> informationDowntimes = downtimeRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return  buildResponse(200,informationDowntimes,"downtime fetched successfully");
    }

    @Override
    public ApiResponseDowntime createDowntime(Long machineId,Long userId,ApiRequestDowntime apiRequestDowntime) {

        Machine machine=machineRepository.findById(machineId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.MACHINE,"machine not found"));

        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.USER,"User not found "));

        Downtime downtime = mapper.map(apiRequestDowntime, Downtime.class);
        downtime.setUser(user);
        downtime.setUserId(userId);
        downtime.setMachineId(machineId);
        downtime.setMachine(machine);
        Downtime savedDowntime = downtimeRepository.save(downtime);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedDowntime)),"downtime created successfully");
    }

    @Override
    public ApiResponseDowntime getDowntimeById(Long downtimeId) {

      Downtime downtime=findByIdOrThrow(downtimeId);
      return buildResponse(200,Collections.singletonList(mapToInfo(downtime)),"downtime found successfully");

    }

    @Override
    public ApiResponseDowntime updateDowntimeById(Long downtimeId, ApiRequestDowntime apiRequestDowntime) {

        Downtime downtime=findByIdOrThrow(downtimeId);
        downtime.setDate(apiRequestDowntime.getDate());
        downtime.setRemarks(apiRequestDowntime.getRemarks());
        downtime.setReason(apiRequestDowntime.getReason());
        downtime.setStartTime(apiRequestDowntime.getStartTime());
        downtime.setEndTime(apiRequestDowntime.getEndTime());
        downtime.setStatus(apiRequestDowntime.getStatus());
        downtime.setDuration(apiRequestDowntime.getDuration());
        Downtime updatedDowntime = downtimeRepository.save(downtime);
        return buildResponse(200,Collections.singletonList(mapToInfo(updatedDowntime)),"downtime updated successfully");
    }

    @Override
    public ApiResponseDowntime deleteDowntimeById(Long downtimeId) {

        Downtime downtime=findByIdOrThrow(downtimeId);
        downtimeRepository.delete(downtime);
        return buildResponse(200,Collections.singletonList(mapToInfo(downtime)),"downtime deleted successfully");
    }

    private Downtime findByIdOrThrow(Long downtimeId)
    {
        return downtimeRepository.findById(downtimeId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.DOWNTIME,"downtime not found"));
    }

    private InformationDowntime mapToInfo(Downtime downtime)
    {
        return mapper.map(downtime, InformationDowntime.class);
    }

    private ApiResponseDowntime buildResponse(int status, List<InformationDowntime> data,String message)
    {
        return new ApiResponseDowntime(status,new DowntimeData(data==null? Collections.emptyList():data),message);
    }

}
