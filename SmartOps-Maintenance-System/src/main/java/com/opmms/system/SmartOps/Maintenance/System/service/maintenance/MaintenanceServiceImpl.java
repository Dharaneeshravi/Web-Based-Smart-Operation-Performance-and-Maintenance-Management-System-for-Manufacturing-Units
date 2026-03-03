package com.opmms.system.SmartOps.Maintenance.System.service.maintenance;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Maintenance;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiRequestMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.ApiResponseMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.InformationMaintenance;
import com.opmms.system.SmartOps.Maintenance.System.payload.maintenance.MaintenanceData;
import com.opmms.system.SmartOps.Maintenance.System.repository.MaintenanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaintenanceServiceImpl implements MaintenanceService {

    private final MaintenanceRepository maintenanceRepository;
    private final ModelMapper modelMapper;

    @Override
    public ApiResponseMaintenance getAllMaintenance() {

        List<InformationMaintenance> informationMaintenances = maintenanceRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return buildResponse(200,informationMaintenances,"maintenance data fetched successfully");
    }

    @Override
    public ApiResponseMaintenance createMaintenance(ApiRequestMaintenance apiRequestMaintenance) {

        Maintenance maintenance = modelMapper.map(apiRequestMaintenance,Maintenance.class);
        Maintenance savedMaintenance = maintenanceRepository.save(maintenance);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedMaintenance)),"maintenance data created successfully");
    }

    @Override
    public ApiResponseMaintenance getMaintenanceById(Long maintenanceId) {

        Maintenance maintenance=findByIdOrThrow(maintenanceId);
        return buildResponse(200,Collections.singletonList(mapToInfo(maintenance)),"maintenance data fetched successfully");
    }

    @Override
    public ApiResponseMaintenance updateMaintenanceById(Long maintenanceId, ApiRequestMaintenance apiRequestMaintenance) {

        Maintenance maintenance=findByIdOrThrow(maintenanceId);
        maintenance.setMaintenanceType(apiRequestMaintenance.getMaintenanceType());
        maintenance.setDescription(apiRequestMaintenance.getDescription());
        maintenance.setScheduledDate(apiRequestMaintenance.getScheduledDate());
        maintenance.setPerformedDate(apiRequestMaintenance.getPerformedDate());
        maintenance.setCost(apiRequestMaintenance.getCost());
        maintenance.setStatus(apiRequestMaintenance.getStatus());
        Maintenance updatedMaintenance=maintenanceRepository.save(maintenance);
        return buildResponse(200,Collections.singletonList(mapToInfo(updatedMaintenance)),"maintenance data updated successfully");
    }

    @Override
    public ApiResponseMaintenance deleteMaintenanceById(Long maintenanceId) {

        Maintenance maintenance=findByIdOrThrow(maintenanceId);
        maintenanceRepository.delete(maintenance);
        return buildResponse(200,Collections.singletonList(mapToInfo(maintenance)),"maintenance data deleted successfully");
    }


    private ApiResponseMaintenance buildResponse(int status, List<InformationMaintenance> data, String message)
    {
        return new ApiResponseMaintenance(status,new MaintenanceData(data==null?Collections.emptyList():data),message);
    }

    private InformationMaintenance mapToInfo(Maintenance maintenance)
    {
        return modelMapper.map(maintenance,InformationMaintenance.class);
    }


    private Maintenance findByIdOrThrow(Long maintenanceId)
    {
        return maintenanceRepository.findById(maintenanceId)
                .orElseThrow(()->new ResourceNotFoundException(200, ResourceType.MAINTENANCE,"maintenance not found"));
    }

}
