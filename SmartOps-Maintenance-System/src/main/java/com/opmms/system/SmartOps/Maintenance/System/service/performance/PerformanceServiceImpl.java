package com.opmms.system.SmartOps.Maintenance.System.service.performance;

import com.opmms.system.SmartOps.Maintenance.System.exception.ResourceNotFoundException;
import com.opmms.system.SmartOps.Maintenance.System.model.Performance;
import com.opmms.system.SmartOps.Maintenance.System.model.ResourceType;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiRequestPerformance;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiResponsePerformance;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.InformationPerformance;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.PerformanceData;
import com.opmms.system.SmartOps.Maintenance.System.repository.PerformanceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

    private final PerformanceRepository performanceRepository;
    private final ModelMapper mapper;


    @Override
    public ApiResponsePerformance getAllPerformance() {

        List<InformationPerformance> informationPerformances = performanceRepository.findAll()
                .stream().map(this::mapToInfo).toList();
        return buildResponse(200,informationPerformances,"performance data fetched successfully");
    }

    @Override
    public ApiResponsePerformance createPerformance(ApiRequestPerformance apiRequestPerformance) {

        Performance performance = mapper.map(apiRequestPerformance, Performance.class);
        Performance savedPerformance = performanceRepository.save(performance);
        return buildResponse(201,Collections.singletonList(mapToInfo(savedPerformance)),"performance created successfully");
    }

    @Override
    public ApiResponsePerformance getPerformanceById(Long performanceId) {

        Performance performance=findByIdOrThrow(performanceId);
        return buildResponse(200,Collections.singletonList(mapToInfo(performance)),"performance data fetched successfully");

    }

    @Override
    public ApiResponsePerformance updatePerformanceById(Long performanceId, ApiRequestPerformance apiRequestPerformance) {

        Performance performance=findByIdOrThrow(performanceId);
        performance.setDate(apiRequestPerformance.getDate());
        performance.setWorkingHours(apiRequestPerformance.getWorkingHours());
        performance.setDowntimeHours(apiRequestPerformance.getDowntimeHours());
        performance.setProductionQty(apiRequestPerformance.getProductionQty());
        performance.setAvailability(apiRequestPerformance.getAvailability());
        performance.setPerformance(apiRequestPerformance.getPerformance());
        performance.setQuality(apiRequestPerformance.getQuality());
        performance.setOee(apiRequestPerformance.getOee());
        Performance updatedPerformance=performanceRepository.save(performance);
        return buildResponse(200,Collections.singletonList(mapToInfo(updatedPerformance)),"performance updated successfully");
    }

    @Override
    public ApiResponsePerformance deletePerformanceById(Long performanceId) {

        Performance performance=findByIdOrThrow(performanceId);
        performanceRepository.delete(performance);
        return buildResponse(200,Collections.singletonList(mapToInfo(performance)),"performance deleted successfully");
    }


    private Performance findByIdOrThrow(Long performanceId)
    {
       return performanceRepository.findById(performanceId)
               .orElseThrow(()->new ResourceNotFoundException(404, ResourceType.PRODUCTION,"performance data fetched successfully"));
    }

    private InformationPerformance mapToInfo(Performance performance)
    {
        return mapper.map(performance,InformationPerformance.class);
    }


    private ApiResponsePerformance buildResponse(int status, List<InformationPerformance> data, String message)
    {
        return new ApiResponsePerformance(status,new PerformanceData(data==null? Collections.emptyList():data),message);
    }
}
