package com.opmms.system.SmartOps.Maintenance.System.service.production;

import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiRequestProduction;
import com.opmms.system.SmartOps.Maintenance.System.payload.production.ApiResponseProduction;

public interface ProductionService {
    ApiResponseProduction getAllProduction();

    ApiResponseProduction createProduction(Long machineId,ApiRequestProduction apiRequestProduction);

    ApiResponseProduction getProductionById(Long productionId);

    ApiResponseProduction updateProductionById(Long productionId, ApiRequestProduction apiRequestProduction);

    ApiResponseProduction deleteProductionById(Long productionId);
}
