package com.opmms.system.SmartOps.Maintenance.System.service.production;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.*;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiRequestProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiResponseProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.InformationProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ProductionData;
import com.opmms.system.SmartOps.Maintenance.System.repository.MachineRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.ProductionRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.ShiftRepository;
import com.opmms.system.SmartOps.Maintenance.System.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements  ProductionService {

    private final ProductionRepository productionRepository;
    private final MachineRepository machineRepository;
    private final UserRepository userRepository;
    private final ShiftRepository shiftRepository;
    private final ModelMapper mapper;

    @Override
    public ApiResponseProduction getAllProduction() {

        List<InformationProduction> informationProductions=productionRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return buildResponse(200,informationProductions,"production fetched successfully");
    }

    @Override
    public ApiResponseProduction createProduction(Long machineId,Long userId,Long shiftId,ApiRequestProduction apiRequestProduction) {

        Machine machine=machineRepository.findById(machineId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.MACHINE,"machine not found"));

        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.USER,"User not found "));

        Shift shift=shiftRepository.findById(shiftId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.SHIFT,"shift not found"));


        Production production=mapToProduction(apiRequestProduction);
        production.setShift(shift);
        production.setShiftId(shiftId);
        production.setMachine(machine);
        production.setUser(user);
        production.setUserId(userId);
        production.setMachineId(machineId);
        Production savedProduction=productionRepository.save(production);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedProduction)),"production created successfully");
    }

    @Override
    public ApiResponseProduction getProductionById(Long productionId) {

        Production production=findByIdOrThrow(productionId);
        return buildResponse(200,Collections.singletonList(mapToInfo(production)),"production fetched successfully");
    }

    @Override
    public ApiResponseProduction updateProductionById(Long productionId, ApiRequestProduction apiRequestProduction) {

        Production production=findByIdOrThrow(productionId);
        production.setProductionDate(apiRequestProduction.getProductionDate());
        production.setRemarks(apiRequestProduction.getRemarks());
        production.setEndTime(apiRequestProduction.getEndTime());
        production.setOutputQty(apiRequestProduction.getOutputQty());
        production.setTotalHours(apiRequestProduction.getTotalHours());
        production.setDefectiveQty(apiRequestProduction.getDefectiveQty());
        production.setStartTime(apiRequestProduction.getStartTime());
        Production savedProduction=productionRepository.save(production);

        return buildResponse(200,Collections.singletonList(mapToInfo(savedProduction)),"production updated successfully");

    }

    @Override
    public ApiResponseProduction deleteProductionById(Long productionId) {

        Production production=findByIdOrThrow(productionId);
        productionRepository.delete(production);
        return buildResponse(200,Collections.singletonList(mapToInfo(production)),"production deleted successfully");
    }


    private ApiResponseProduction buildResponse(int status, List<InformationProduction> productions,String message)
    {
        return new ApiResponseProduction(status,new ProductionData(productions==null? Collections.emptyList():productions),message);
    }

    private InformationProduction mapToInfo(Production production)
    {
        return mapper.map(production,InformationProduction.class);
    }

    private Production mapToProduction(ApiRequestProduction apiRequestProduction)
    {
        return  mapper.map(apiRequestProduction,Production.class);
    }

    private Production findByIdOrThrow(Long productionId)
    {
        return productionRepository.findById(productionId)
                .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.PRODUCTION,"production not found"));
    }
}
