package com.opmms.system.SmartOps.Maintenance.System.service.production;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Production;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiRequestProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiResponseProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ProductionData;
import com.opmms.system.SmartOps.Maintenance.System.repository.ProductionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductionServiceImpl implements  ProductionService {

    private final ProductionRepository productionRepository;
    private final ModelMapper mapper;

    @Override
    public ApiResponseProduction getAllProduction() {

        List<Production> productionList=productionRepository.findAll();
        return buildResponse(200,productionList,"production fetched successfully");
    }

    @Override
    public ApiResponseProduction createProduction(ApiRequestProduction apiRequestProduction) {

        Production production=mapToProduction(apiRequestProduction);
        Production savedProduction=productionRepository.save(production);
        return buildResponse(201,Collections.singletonList(production),"production created successfully");
    }

    @Override
    public ApiResponseProduction getProductionById(Long productionId) {

        Production production=findByIdOrThrow(productionId);
        return buildResponse(200,Collections.singletonList(production),"production fetched successfully");
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

        return buildResponse(200,Collections.singletonList(savedProduction),"production updated successfully");

    }

    @Override
    public ApiResponseProduction deleteProductionById(Long productionId) {

        Production production=findByIdOrThrow(productionId);
        productionRepository.delete(production);
        return buildResponse(200,Collections.singletonList(production),"production deleted successfully");
    }


    private ApiResponseProduction buildResponse(int status, List<Production> productions,String message)
    {
        return new ApiResponseProduction(status,new ProductionData(productions==null? Collections.emptyList():productions),message);
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
