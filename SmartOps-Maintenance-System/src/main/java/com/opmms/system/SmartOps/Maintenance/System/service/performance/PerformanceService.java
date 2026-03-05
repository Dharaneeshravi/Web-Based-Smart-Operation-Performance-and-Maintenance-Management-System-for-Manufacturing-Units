package com.opmms.system.SmartOps.Maintenance.System.service.performance;

import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiRequestPerformance;
import com.opmms.system.SmartOps.Maintenance.System.payload.performance.ApiResponsePerformance;

public interface PerformanceService {
    ApiResponsePerformance getAllPerformance();

    ApiResponsePerformance createPerformance(Long machineId,ApiRequestPerformance apiRequestPerformance);

    ApiResponsePerformance getPerformanceById(Long performanceId);

    ApiResponsePerformance updatePerformanceById(Long performanceId, ApiRequestPerformance apiRequestPerformance);

    ApiResponsePerformance deletePerformanceById(Long performanceId);
}
